package task.test.captify

import org.specs2.mutable.Specification

import scala.collection.mutable.ListBuffer

class Task1Test extends Specification {

  override def is =
    s2"""
         This is spec for task1
         Task1 lists all airports with total number of planes for the whole period that arrived to each airport
         Check execution: $test1

  """

  val dests: ListBuffer[String] = ListBuffer("LAX", "KBP", "LAX", "LAX", "KBP", "LAX")

  val origins: ListBuffer[String] = ListBuffer("JFK", "JFK", "KBP", "JFK", "JFK", "KBP")

  val expectedResult = "KBP 2\nLAX 4\nJFK 0"

  def test1: Boolean = new Task1(dests, origins).execute mustEqual expectedResult
}