package net.devalias.poc.scalaXmlXDocReport

import scala.beans.BeanProperty

import com.lucidchart.open.xtract.{XmlReader, __}
import com.lucidchart.open.xtract.XmlReader._
import play.api.libs.functional.syntax._

// Ref:
//   https://github.com/lucidsoftware/xtract
//   https://www.lucidchart.com/techblog/2016/07/12/introducing-xtract-a-new-xml-deserialization-library-for-scala/
//   http://lucidsoftware.github.io/xtract/core/api/#package

case class Foo(@BeanProperty var foo: String, @BeanProperty var bar: String, @BeanProperty var baz: String)

object Foo {
  implicit val reader: XmlReader[Foo] = (
    (__ \ "foo").read[String] and
    (__ \ "bar").read[String] and
    (__ \ "baz").read[String]
  )(apply _)
}
