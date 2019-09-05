package zeab.udpclient

//Imports
import com.typesafe.config.{Config, ConfigFactory}

trait AppConf {
  val appConf: Config = ConfigFactory.load()
}

object AppConf extends AppConf {
  val pulseInterval: Int = appConf.getInt("udp.pulseInterval")
  val datagram: String = appConf.getString("udp.datagram")
}
