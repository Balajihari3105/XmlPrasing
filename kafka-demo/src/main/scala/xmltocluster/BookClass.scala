package xmltocluster

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

object BookClass {
  case class Book(@JacksonXmlProperty(localName = "id") id: String,
                  @JacksonXmlProperty(localName = "author") author: String,
                  @JacksonXmlProperty(localName = "title") title: String,
                  @JacksonXmlProperty(localName = "genre") genre: String,
                  @JacksonXmlProperty(localName = "price") price: Double,
                  @JacksonXmlProperty(localName = "publish_date") publishDate: String,
                  @JacksonXmlProperty(localName = "description") description: String)
}
