import Dependencies._

lazy val commonSettings = Seq(
  organization := "com.github.aoiroaoino",
  scalaVersion := "2.12.6",
  version      := "0.1.0-SNAPSHOT",
  name         := "jsondsl",
  libraryDependencies ++= Seq(
    scalaTest % Test
  )
)

lazy val root = (project in file("."))
  .settings(commonSettings)
  .aggregate(core, playJson, circe)
  .dependsOn(core, playJson, circe)

lazy val core = project
  .settings(commonSettings)
  .settings(moduleName := "jsondsl-core")

lazy val playJson = project
  .settings(commonSettings)
  .settings(moduleName := "jsondsl-play-json")
  .settings(libraryDependencies += "com.typesafe.play" %% "play-json" % "2.6.7")
  .dependsOn(core)

lazy val circe = project
  .settings(commonSettings)
  .settings(moduleName := "jsondsl-circe")
  .settings(libraryDependencies += "io.circe" %% "circe-core" % "0.9.3")
  .dependsOn(core)
