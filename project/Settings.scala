
//Imports
import Common.seqBaseProjectTemplate
import Versions._
import sbt.Def

//Settings
object Settings {
  val udpServiceSettings: Seq[Def.Setting[_]] = seqBaseProjectTemplate(udpServiceVersion)
  val udpClientSettings: Seq[Def.Setting[_]] = seqBaseProjectTemplate(udpClientVersion)
}
