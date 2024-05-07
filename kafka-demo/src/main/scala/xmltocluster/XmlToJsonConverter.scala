package xmltocluster
import xmltocluster.Protocol

import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import spray.json.{DefaultJsonProtocol, enrichAny}

import java.io.File
//trait Protocol extends DefaultJsonProtocol{
//  implicit val bookFormat = jsonFormat7(Book)
//}

object XmlToJsonConverter extends App with Protocol {

  case class Book(@JacksonXmlProperty(localName = "id") id: String,
                  @JacksonXmlProperty(localName = "author") author: String,
                  @JacksonXmlProperty(localName = "title") title: String,
                  @JacksonXmlProperty(localName = "genre") genre: String,
                  @JacksonXmlProperty(localName = "price") price: Double,
                  @JacksonXmlProperty(localName = "publish_date") publishDate: String,
                  @JacksonXmlProperty(localName = "description") description: String)

  // Read XML data into Book instances
  val xmlMapper = new XmlMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
  val books: List[Book] = xmlMapper.readValue(new File("/Users/macbookpro/Desktop/DeskTop/kafka/kafka-demo/book.xml"), classOf[Array[Book]]).toList
  books.foreach(println(_))
  // Convert Book instances to JSON

//  books.map(_.toJson).foreach(println(_))

//  val objectMapper = new ObjectMapper
//  val jsonOutput: String = objectMapper.writeValueAsString(books)

  //  // Print JSON output
//  jsonOutput.foreach(println(_))
}
