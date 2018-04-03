package net.devalias.poc.scalaXmlXDocReport

import java.io._
import scala.util.{Failure, Success, Try}
import scala.xml.XML

import com.lucidchart.open.xtract.{ParseFailure, ParseSuccess, PartialParseSuccess, XmlReader}
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry
import fr.opensagres.xdocreport.template.{IContext, TemplateEngineKind}

object Main {

  def main(args: Array[String]): Unit = {
    val fooXml = "./foo.xml"
    val docxTemplate = "./foo.template.docx"
    val docxReport = "./foo.docx"

    // Read/parse XML
    val doc = XML.loadFile(fooXml)

    val foo = XmlReader.of[Foo].read(doc) match {
      case ParseSuccess(f) => Success(f)
      case PartialParseSuccess(_, err) => Failure(new Throwable("Failed to parse XML: " + err.mkString))
      case ParseFailure(err) => Failure(new Throwable("Failed to parse XML: " + err.mkString))
    }

    foo match {
      case Success(f) => println("foo xml reading success: " + f)
      case Failure(err) => println("foo xml reading failed: " + err)
    }

//    val template: Try[InputStream] = Try(getClass.getResourceAsStream(docxTemplate))
    val template: Try[InputStream] = Try(new FileInputStream(docxTemplate))
    val report = template.map { template =>
      XDocReportRegistry.getRegistry.loadReport(template, TemplateEngineKind.Velocity)
    }

//    val metadata = report.createFieldsMetadata
//    val metadata = new FieldsMetadata()
//    metadata.addFieldAsList("persons.name")
//    metadata.addFieldAsList("persons.surname")
//    metadata.addFieldAsTextStyling("foo.bar", SyntaxKind.Html)
//    metadata.addFieldAsTextStyling("foo.bar", SyntaxKind.MarkDown)
//    report.setFieldsMetadata(metadata)

    val context: Try[IContext] = report.map { _.createContext() }

    for {
      c <- context
      f <- foo
    } yield {
      c.put("title", "Hello World!")
      c.put("foo", f)
    }

//    val out: Try[OutputStream] = Try(new ByteArrayOutputStream(1024))
    val out: Try[OutputStream] = Try(new FileOutputStream(new File(docxReport)))

    val result = for {
      r <- report
      c <- context
      o <- out
    } yield {
      r.process(c, o)
    }

    result match {
      case Success(_) => println("Report written successfully!")
      case Failure(err) => println("Error writing report: " + err.getMessage)
    }
  }

}