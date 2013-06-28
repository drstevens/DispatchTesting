Revolver.settings

resolvers += "Typesafe Snapshots" at "http://repo.typesafe.com/typesafe/snapshots/"

resolvers += "spray repo" at "http://repo.spray.io"
 
libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % "6.0.4",
  "joda-time" % "joda-time" % "2.2",
  "org.joda" % "joda-convert" % "1.3.1",
  "org.slf4j" % "slf4j-api" % "1.6.6",
  "ch.qos.logback" % "logback-classic" % "1.0.6",
  "com.typesafe" %% "scalalogging-slf4j" % "1.0.1",
  "net.databinder.dispatch" %% "dispatch-core" % "0.10.0",
  "io.spray" %%  "spray-json" % "1.2.3"
)
 
initialCommands in console := "import scalaz._, Scalaz._"
