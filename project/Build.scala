import sbt._
import sbt.Keys._

object DispatchtestingBuild extends Build {

  lazy val dispatchtesting = Project(
    id = "dispatchtesting",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "DispatchTesting",
      organization := "org.example",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.1",
      scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-language:postfixOps")
      // add other settings here
    )
  )
}
