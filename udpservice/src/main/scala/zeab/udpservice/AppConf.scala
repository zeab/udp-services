package zeab.udpservice

//Imports
import com.typesafe.config.{Config, ConfigFactory}

trait AppConf {
  val appConf: Config = ConfigFactory.load()
}

object AppConf extends AppConf {
  val udpHost: String = appConf.getString("udp.host")
  val udpPort: String = appConf.getInt("udp.port").toString
}
