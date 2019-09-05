package zeab.udpservice

//Imports
import java.net.InetSocketAddress
//Slf4j
import org.slf4j.{Logger, LoggerFactory}
//Akka
import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.io.{IO, Udp}
import com.typesafe.config.ConfigFactory

object UdpService extends App {

  //Akka
  implicit val system: ActorSystem = ActorSystem("UdpService", ConfigFactory.load())
  val log: Logger = LoggerFactory.getLogger("stdout")

  //Start the udp service listening on the host and port
  log.info("Attempting to start udp service")
  system.actorOf(Props(classOf[UdpService])) ! StartUdpService(AppConf.udpHost, AppConf.udpPort)

}

class UdpService extends Actor{

  val log: Logger = LoggerFactory.getLogger("stdout")

  implicit val actorSystem: ActorSystem = context.system

  def receive: Receive = disconnected

  def disconnected: Receive = {
    case m: StartUdpService =>
      log.info(s"Binding Udp server to ${m.host}:${m.port}")
      IO(Udp) ! Udp.Bind(self, new InetSocketAddress(m.host, m.port.toInt))
      context.become(connected(sender()))
    case Udp.Received(_, _) => log.error("Ucp is disconnected but the actor is still being sent messages")
  }

  def connected(socket: ActorRef): Receive = {
    case Udp.Received(data, _) => log.info(data.utf8String)
    case Udp.Unbind =>
      log.info("Unbinding Udp server")
      socket ! Udp.Unbind
    case Udp.Unbound =>
      log.info("Stopping Udp server")
      context.stop(self)
      context.become(disconnected)
      log.info("Service is terminating")
      context.system.terminate()
  }

}