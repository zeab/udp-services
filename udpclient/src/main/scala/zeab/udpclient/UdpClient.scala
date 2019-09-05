package zeab.udpclient

//Imports
import java.util.UUID

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import org.slf4j.{Logger, LoggerFactory}

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

object UdpClient extends App {

  //Akka
  implicit val system: ActorSystem = ActorSystem("UdpClient", ConfigFactory.load())
  implicit val ec: ExecutionContext = system.dispatcher
  val log: Logger = LoggerFactory.getLogger("stdout")
  val udp: Logger = LoggerFactory.getLogger("udp")
  log.info("Starting Udp Client")

  system.scheduler.schedule(0.second, AppConf.pulseInterval.second){
    if (AppConf.datagram == ""){
      val datagram: String = s"Ahoy! - ${UUID.randomUUID()}"
      log.info(s"Datagram: $datagram")
      udp.info(datagram)
    }
    else{
      log.info(s"Datagram: ${AppConf.datagram}")
      udp.info(AppConf.datagram)
    }
  }

}
