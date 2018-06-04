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
  .aggregate(core)
  .dependsOn(core)

lazy val core = project
  .settings(commonSettings)
  .settings(moduleName := "jsondsl-core")
