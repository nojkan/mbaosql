import com.typesafe.config.ConfigFactory
import com.typesafe.sbt.packager.docker._


name := """mbaosql"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean,JavaAppPackaging,DockerPlugin)

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

dockerRepository:=Some("docker-registry.kmt-beta.orange-labs.fr:80/mqhg9062")
//dockerRepository := Some("nojkan")
maintainer in Docker:= "Erwan Diverrez <erwan.diverrez@orange.com>"
libraryDependencies += filters
resolvers += "sedis-fix" at "https://dl.bintray.com/graingert/maven/"


packageName in Docker := "mbaosql"
dockerExposedPorts := Seq(9000)
dockerEntrypoint :=Seq("bin/mbaosql")


dockerCommands  ++=Seq(ExecCmd("CMD","-Dconfig.resource=application.conf"),
                        ExecCmd("RUN","mkdir","-p","/opt/docker/logs"),
                        ExecCmd("RUN","chmod","-R","777","/opt/docker/logs"),
                        Cmd("USER","root"),
                        ExecCmd("RUN","apt-get","update"),
                        ExecCmd("RUN","apt-get","install","-y","vim"),
                        Cmd("USER","daemon"))
