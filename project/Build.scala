import sbt._
import Keys._

object ApplicationBuild extends Build {
  val project_settings = Defaults.defaultSettings ++ Seq(
    scalaVersion in ThisBuild := "2.10.1"
  )

  lazy val test1 = Project(id = "test1", base = file("test1"), settings = project_settings)

  lazy val test2 = Project(id = "test2", base = file("test2"), settings = project_settings) dependsOn(test1)

  lazy val test3 = Project(id = "test3", base = file("test3"), settings = project_settings) dependsOn(test2)

  lazy val main = Project(id = "main", base = file("main"), settings = project_settings) dependsOn(test3)

  lazy val root = Project(id = "root",
    base = file(".")
    ) aggregate(test1, test2, test3, main)
}

