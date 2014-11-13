package xmlparser

import scala.util.parsing.combinator.RegexParsers

/**
 * Contains the actual parser for parsing XML into DOMs.
 *
 * Created by hawk on 11/12/14.
 */
object XMLParser extends RegexParsers {
  // Regular expression for an acceptable name string.
  // TODO: this currently doesn't support Unicode combining characters; figure that out.
  val name = """[a-zA-Z_:][a-zA-Z0-9\.-_:]*""".r

 def element: Parser[Element] = "<" ~> name ~ attr.* ~ ">" ~ element.*  <~ """<\""" <~ name <~ ">" ^^ {
    case ident ~ attrs ~ ">" ~ elems => new Element(ident, elems, attrs)
  } | "<" ~> name ~ attr.* ~ ">" ~ text  <~ """<\""" <~ name <~ ">" ^^ {
    case  ident ~ attrs ~ ">" ~ text => new Leaf(ident, text, attrs)
  }
  def attr: Parser[Attribute] = name ~ "=" ~ text ^^{ case i ~ "=" ~ v => Attribute(i,v) }
  def text: Parser[String] = "\"" ~> """[^\"]""".r <~ "\""

}
