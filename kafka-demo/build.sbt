ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.13"

lazy val root = (project in file("."))
  .settings(
    name := "kafka-XML-stream"
  )
libraryDependencies += "org.apache.kafka" % "kafka-clients" % "3.3.1"
libraryDependencies += "org.apache.kafka" %% "kafka" % "3.6.1"
libraryDependencies += "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.20.0"
libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.5.6",
  "ch.qos.logback" % "logback-core" % "1.5.6"
)
// https://mvnrepository.com/artifact/org.scala-lang.modules/scala-xml
libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "2.3.0"
// https://mvnrepository.com/artifact/org.apache.kafka/kafka-streams
libraryDependencies += "org.apache.kafka" % "kafka-streams" % "3.6.2"

libraryDependencies +="com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.17.0"
// https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-xml
libraryDependencies += "com.fasterxml.jackson.dataformat" % "jackson-dataformat-xml" % "2.17.1"
// https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.14.0"
// https://mvnrepository.com/artifact/com.nryanov.consul4s/consul4s-spray-json
libraryDependencies += "com.nryanov.consul4s" %% "consul4s-spray-json" % "0.7.0"
