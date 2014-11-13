package xmlparser

/**
 * Contains classes providing a tree representation of the XML DOM
 *
 * Created by hawk on 11/12/14.
 */
abstract class Node(ident: String)
class Element(ident: String,
              children: List[Node],
              attributes: List[Attribute]) extends Node(ident) {
  def apply(ident: String,
            content: List[Node] = List(),
            attributes: List[Attribute] = List()): Element = new Element(ident,children,attributes)
}
class Leaf(ident: String, text: String, attributes: List[Attribute]) extends Element(ident, Nil, attributes)
case class Attribute(ident: String, value: String) extends Node(ident)