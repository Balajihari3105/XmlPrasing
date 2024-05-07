package xmltocluster

import java.io.File
import scala.xml._

object ScalaXmlPraserDemo extends App {

  case class Book(id: String,
                  author: String,
                  title: String,
                  genre: String,
                  price: String,
                  publishDate: String,
                  description: String)

  //  val xmlString =
  //    """<?xml version="1.0"?>
  //      |<catalog>
  //      |    <book id="bk101">
  //      |        <author>Gambardella, Matthew</author>
  //      |        <title>XML Developer's Guide</title>
  //      |        <genre>Computer</genre>
  //      |        <price>44.95</price>
  //      |        <publish_date>2000-10-01</publish_date>
  //      |        <description>An in-depth look at creating applications with XML.</description>
  //      |    </book>
  //      |</catalog>""".stripMargin
  //  val xml: Elem = XML.loadString(xmlString)
  val xmlFile = new File("/Users/macbookpro/Desktop/DeskTop/kafka/kafka-demo/book.xml").toString
  val xml = XML.loadString(xmlFile)
  try {
    val books = (xml \\ "Book").map { x =>
      println("book")
      val id = (x \ "id").text
      val author = (x \ "author").text
      val title = (x \ "title").text
      val genre = (x \ "genre").text
      val price = (x \ "price").text
      val publishDate = (x \ "publish_date").text
      val description = (x \ "description").text
      Book(id, author, title, genre, price, publishDate, description)
    }

    // Print each book
    books.foreach(println)

  } catch {
    case e => e.printStackTrace()
  }


}
