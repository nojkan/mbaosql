name := """mbao"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)


libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1206-jdbc42"

libraryDependencies += "org.webjars" % "jquery" % "1.11.2"

libraryDependencies += "org.webjars" % "bootstrap" % "2.1.1"
libraryDependencies += "com.typesafe.play" % "play-json_2.11" % "2.5.0"
libraryDependencies += "commons-beanutils" % "commons-beanutils" % "1.9.3"

