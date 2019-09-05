
//Imports
import Settings._
import Dependencies._
import Docker._
import ModuleNames._

//Sbt Log Level
logLevel := Level.Info

//Add all the command alias's
CommandAlias.allCommandAlias

lazy val udpservice = (project in file(udpServiceKey))
  .settings(udpServiceSettings: _*)
  .settings(libraryDependencies ++= commonDependencies)
  .settings(udpServiceDockerSettings)
  .enablePlugins(AshScriptPlugin)
  .enablePlugins(AssemblyPlugin)

lazy val udpclient = (project in file(udpClientKey))
  .settings(udpClientSettings: _*)
  .settings(libraryDependencies ++= commonDependencies)
  .settings(udpClientDockerSettings)
  .enablePlugins(AshScriptPlugin)
  .enablePlugins(AssemblyPlugin)