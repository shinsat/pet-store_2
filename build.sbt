lazy val `pfe-scala` = project.in(file(".")).enablePlugins(PlayScala).dependsOn(service, oauth)

name := "pet-store_2"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  filters,
  cache,
  "org.webjars" % "requirejs" % "2.1.22",
  "org.mockito" % "mockito-core" % "1.10.19" % Test,
  component("play-specs2") % Test
)

scalaVersion in ThisBuild := "2.11.8"

scalacOptions in ThisBuild += "-feature"

includeFilter in (Assets, LessKeys.less) := "shop.less"

pipelineStages := Seq(rjs, gzip, digest)

CoffeeScriptKeys.bare := true

RjsKeys.mainModule := "shop"

RjsKeys.paths += "routes" -> ("routes", "empty:")

lazy val service = project.settings(
  libraryDependencies ++= Seq(
    "com.typesafe.slick" %% "slick" % "3.1.1",
    jdbc,
    ws,
    evolutions,
    "org.specs2" %% "specs2-core" % "3.7" % "test",
    component("play-test") % "test"
  )
)

lazy val oauth = project.enablePlugins(PlayScala).settings(
  libraryDependencies ++= Seq(
    ws
  )
)
