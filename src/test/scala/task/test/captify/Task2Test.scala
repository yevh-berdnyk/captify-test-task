package task.test.captify

import org.specs2.mutable.Specification

import scala.collection.mutable.ListBuffer

class Task2Test extends Specification {

  override def is =
    s2"""
         This is spec for task2
         Task2 returns non-zero difference in total number of planes that arrived to and left from the airport
         Check execution: $test1
  """

  val dests: ListBuffer[String] = ListBuffer("LAX", "KBP", "LAX", "LAX", "KBP", "LAX")

  val origins: ListBuffer[String] = ListBuffer("JFK", "JFK", "KBP", "JFK", "JFK", "KBP")

  val expectedResult = "LAX 4\nJFK -4"

  def test1: Boolean = new Task2(dests, origins).execute mustEqual expectedResult
}