# poc-scalaXmlXDocReport

PoC playing with merging a `.docx` template with an XML datasource using [opensagres/xdocreport](https://github.com/opensagres/xdocreport) and [Scala](https://www.scala-lang.org/).

## Setup

```
sbt clean compile
```

## Usage

```
sbt run
```

## References

* [opensagres/xdocreport](https://github.com/opensagres/xdocreport): API to merge docx/odt document with a model to generate a report
  * [Getting Started](https://github.com/opensagres/xdocreport/wiki/GettingStarted)
  * [opensagres/xdocreport.samples](https://github.com/opensagres/xdocreport.samples)
* [lucidsoftware/xtract](https://github.com/lucidsoftware/xtract): A library to make it easy to deserialize XML to user types in scala
  * [Introduction Blog Post](https://www.lucidchart.com/techblog/2016/07/12/introducing-xtract-a-new-xml-deserialization-library-for-scala/)
  * [API](http://lucidsoftware.github.io/xtract/core/api/#package)
  * [Example](https://github.com/lucidsoftware/xtract-example)
* [scala/scala-xml](https://github.com/scala/scala-xml): The standard Scala XML library
  * [Getting Started](https://github.com/scala/scala-xml/wiki/Getting-started)
* [lsgro/xdocreport-odt-sample](https://github.com/lsgro/xdocreport-odt-sample/blob/master/src/main/scala/XDocReportOdtSample.scala): Example XDocReport Scala Project
* [felixgborrego/sDoc2Pdf](https://github.com/felixgborrego/sDoc2Pdf/blob/master/src/main/scala/io/github/scala/sdoc2pdf/XDocReportUtil.scala): Example Scala wrapper DSL around XDocReport
