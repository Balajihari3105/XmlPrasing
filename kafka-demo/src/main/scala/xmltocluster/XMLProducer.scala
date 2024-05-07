package xmltocluster

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}
import org.apache.kafka.common.serialization.StringSerializer
import org.slf4j.{Logger, LoggerFactory}

import java.util.Properties
import scala.xml.XML

object XMLProducer {
  val logger: Logger = LoggerFactory.getLogger(this.getClass)

  def main(args: Array[String]): Unit = {
    val config: Properties = new Properties();
    config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:39092")
    config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer].getName)
    config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer].getName)
    val producer: KafkaProducer[String, String] = new KafkaProducer(config)
    var i = 0
    while (i < 1000) {
      val xmlString = XML.loadFile("/Users/macbookpro/Desktop/DeskTop/kafka/kafka-demo/book.xml").toString()
      logger.info(" xml loaded ")
      producer.send(new ProducerRecord("xmldata", xmlString))
      logger.info(s"$i")
      i= i+1
    }
    producer.flush()
    producer.close()


  }

}
