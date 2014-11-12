package xmlparser

/**
 * Created by hawk on 11/12/14.
 */
abstract class Node {

}
case class Element(children: Set[Node], parent: Option[Element]) extends Node {
  def isRoot: Boolean = parent.isEmpty
  def apply(children: Set[Node] = Set()): Element = new Element(children,Some(this))
}