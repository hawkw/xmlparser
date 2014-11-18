package xmlparser
import scala.collection.immutable.map

/**
 * Contains classes providing a tree representation of the XML DOM
 *
 * Created by hawk on 11/12/14.
 */
class Element(ident: String,
              parent: Element,
              children: List[Element],
              attrs: Attrs) extends Node(ident) {
                            
  type Attrs = Map[String, String]
  
  def apply(ident: String,
            content: List[Element] = List(),
            attrs: Attrs = List()): Element = new Element(ident,this,children,attrs)
}
class Leaf(   ident: String, 
              parent: Element,
              text: String,
              attrs: Attrs
              ) extends Element(ident, parent, Nil, attrs)
