package xmltocluster

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.kstream.KStream
import org.apache.kafka.streams.{KafkaStreams, StreamsBuilder, StreamsConfig}
import org.slf4j.{Logger, LoggerFactory}
import spray.json.{JsValue, enrichAny, jsonReader}
import xmltocluster.BookClass.Book

import java.util.Properties

object XmlStreamApp extends App with Protocol {
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

  // Define your Book case class here

  private def xmlToCaseClass(xmlString: String) = {
    val xmlMapper = new XmlMapper()
    val books: List[Book] = xmlMapper.readValue(xmlString, classOf[Array[Book]]).toList
    println(books)
    books
  }

  private def convertToJson(books: List[Book]) = {
    println(books)
    books.toJson.prettyPrint // Efficient JSON conversion using Spray JSON
  }

  val processedStream: KStream[String, String] = inputStream.mapValues { value =>
    println(value)
    val xmlString = value
    val books = xmlToCaseClass(xmlString)
    val jsonString = convertToJson(books)
    log.info(s"Successfully converted XML to JSON: $jsonString") // Log the message
    jsonString
  }

  processedStream.to("json2")

  val streams = new KafkaStreams(builder.build(), config)
  streams.cleanUp()
  streams.start()
}
