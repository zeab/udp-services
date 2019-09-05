//Imports
import sbt._

object Dependencies {

  //List of Versions
  val V = new {
    val akka                        = "2.5.22"
    val akkaHttp                    = "10.1.8"
    val logbackJson                 = "6.1"
    val logback                     = "1.2.3"
    val scalaTest                   = "3.0.5"
  }

  //List of Dependencies
  val D = new {
    //Akka
    val akkaStream                  = "com.typesafe.akka" %% "akka-stream" % V.akka
    //Akka Http
    val akkaHttp                    = "com.typesafe.akka" %% "akka-http" % V.akkaHttp
    //Logging
    val logback                     = "ch.qos.logback" % "logback-classic" % V.logback
    val logbackJson                 = "net.logstash.logback" % "logstash-logback-encoder" % V.logbackJson
    //Test
    val scalaTest                   = "org.scalatest" %% "scalatest" % V.scalaTest % "test"
    val akkaTestKit                 = "com.typesafe.akka" %% "akka-testkit" % V.akka % Test
  }

  val commonDependencies: Seq[ModuleID] = Seq(
    D.akkaStream,
    D.akkaHttp,
    D.logback,
    D.logbackJson,
    D.scalaTest,
    D.akkaTestKit
  )

}
