package task.test.captify

import org.specs2.mutable.Specification

import scala.collection.mutable.ListBuffer

class Task3Test extends Specification {

  override def is =
    s2"""
         This is spec for task3
         Task3 lists all airports with total number of planes that arrived to each airport separately per each week
         Check execution: $test1
  """

  val a = new FlightRaw(2014, 1, 1, 1, 3, "2014-01-01", "JFK", "LAX")
  val b = new FlightRaw(2014, 1, 1, 5, 7, "2014-01-05", "JFK", "KBP")
  val c = new FlightRaw(2014, 1, 1, 6, 1, "2014-01-06", "KBP", "LAX")
  val d = new FlightRaw(2014, 1, 1, 8, 3, "2014-01-08", "JFK", "LAX")
  val e = new FlightRaw(2014, 1, 1, 12, 7, "2014-01-12", "JFK", "KBP")
  val f = new FlightRaw(2014, 1, 1, 13, 1, "2014-01-13", "KBP", "LAX")
  val flights: ListBuffer[FlightRaw] = ListBuffer(a, b, c, d, e, f)

  val expectedResult = "W1 \n LAX 1\n JFK 0\nW2 \n KBP 1\n LAX 2\n JFK 0\nW3 \n KBP 1\n LAX 1\n JFK 0"

  def test1: Boolean = new Task3(flights).execute mustEqual expectedResult
}