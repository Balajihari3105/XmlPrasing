package sampleCode

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}
import org.apache.kafka.common.serialization.StringSerializer
import org.slf4j.LoggerFactory

import java.util.Properties
import scala.util.Random

object SimpleKafkaProducer {
  def main(args: Array[String]): Unit = {
    println("prodeucer started")
    val logger = LoggerFactory.getLogger(this.getClass)
    val config: Properties = new Properties();
    config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:39092")
    config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer].getName)
    config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer].getName)
    val producer: KafkaProducer[String, String] = new KafkaProducer(config)
    try {

      val list = List("balaji", "hari", "dhanusd", "some")
      list.foreach { x =>
        logger.info(" record begin to produce")
        val record = new ProducerRecord[String, String]("test", Random.nextInt().toString, x)
        logger.info("producing record.................. ")
        producer.send(record)
      }
    }
    catch {
      case e => e.printStackTrace()
    }
    finally {
      producer.flush()
      producer.close()

    }
  }

}