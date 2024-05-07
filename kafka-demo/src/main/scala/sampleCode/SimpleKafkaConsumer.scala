package sampleCode

import org.apache.kafka.clients.consumer.{ConsumerConfig, ConsumerRecords, KafkaConsumer}
import org.apache.kafka.common.TopicPartition
import org.apache.kafka.common.serialization.StringDeserializer
import org.slf4j.{Logger, LoggerFactory}

import java.time.Duration
import java.util.{Collections, Properties}
import scala.jdk.CollectionConverters.{iterableAsScalaIterableConverter, seqAsJavaListConverter}

object SimpleKafkaConsumer extends App {
  val log: Logger = LoggerFactory.getLogger(this.getClass)

  val servers ="localhost:29092,localhost:39092,localhost:49092"
  val config: Properties = new Properties()
  config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers)
  config.put(ConsumerConfig.GROUP_ID_CONFIG, "word-count-consumer-group")
  config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer].getName)
  config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer].getName)
  config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")

  val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](config)
  try {
    val topic ="json2"
    val partitions = consumer.partitionsFor(topic).asScala.map(_.partition())

    consumer.subscribe(Collections.singletonList("json2"))
    consumer.poll(0)
    for (partition <- partitions) {
      val topicPartition = new TopicPartition(topic, partition)
      consumer.seekToBeginning(List(topicPartition).asJava)
    }
    while (true) {
      log.info("pollinng the data ................ ")
      val records: ConsumerRecords[String, String] = consumer.poll(Duration.ofMillis(1000))
      records.asScala.foreach { record =>
        log.info("polled the data ................ ")
        println(s"Word: ${record.key()}, Count: ${record.value()}")
      }
    }
  } catch {
    case e: Exception => log.error("Error occurred: {}", e.getMessage)
  } finally {
    consumer.close()
  }
}
