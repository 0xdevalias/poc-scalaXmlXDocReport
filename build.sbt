name := "poc-scalaXmlXDocReport"

version := "0.1"

scalaVersion := "2.12.5"

mainClass in (Compile, run) := Some("net.devalias.poc.scalaXmlXDocReport.Main")

libraryDependencies ++= {
  val xDocReportVer = "2.0.1"
  val poiVer = "3.17"
  Seq(
    // XML
    "com.lucidchart" %% "xtract" % "1.3.1",
    "org.scala-lang.modules" %% "scala-xml" % "1.1.0",
    // XDocReport
    "fr.opensagres.xdocreport" % "fr.opensagres.xdocreport.core" % xDocReportVer,
    "fr.opensagres.xdocreport" % "fr.opensagres.xdocreport.document.docx" % xDocReportVer,
    "fr.opensagres.xdocreport" % "fr.opensagres.xdocreport.template.velocity" % xDocReportVer,
    // Etc
    "org.apache.poi" % "poi" % poiVer
//    "org.apache.poi" % "poi-ooxml" % poiVer,
//    "org.apache.poi" % "poi-ooxml-schemas" % poiVer,
//    "org.docx4j" % "docx4j-ImportXHTML" % "3.3.6-1",
  )
}