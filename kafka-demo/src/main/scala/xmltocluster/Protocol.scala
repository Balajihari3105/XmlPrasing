package xmltocluster

import spray.json.DefaultJsonProtocol

trait Protocol extends DefaultJsonProtocol{
  implicit val bookFormat = jsonFormat7(BookClass.Book)
}
