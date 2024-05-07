package xmltocluster

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.{StreamsBuilder, StreamsConfig}
import org.apache.kafka.streams.kstream.KStream
import org.slf4j.{Logger, LoggerFactory}

import java.util.Properties

object ScalaXmlPraserStreamApp extends App{
  val log: Logger = LoggerFactory.getLogger(this.getClass)
  val config = new Properties()
  val server = "localhost:29092,localhost:39092,localhost:49092"
  config.put(StreamsConfig.APPLICATION_ID_CONFIG, "Xml-marshalling-App")
  config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, server)
  config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String.getClass)
  config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String.getClass)
  config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")

  val builder: StreamsBuilder = new StreamsBuilder()
  val inputStream: KStream[String, String] = builder.stream("xmldata")


}
