package task.test.captify

import org.specs2.mutable.Specification

import scala.collection.mutable.ListBuffer

class InputManagerTest extends Specification {

  override def is =
    s2"""
         This is spec for InputManager
         Check that correct input file produces expected list of values: $test1
         Check that non-existing input file produces null: $test2
         Check that empty input file produces empty list: $test3
  """

  val a = new FlightRaw(2014, 1, 1, 1, 3, "2014-01-01", "JFK", "LAX")
  val b = new FlightRaw(2014, 1, 1, 5, 7, "2014-01-05", "JFK", "KBP")
  val c = new FlightRaw(2014, 1, 1, 6, 1, "2014-01-06", "KBP", "LAX")
  val d = new FlightRaw(2014, 1, 1, 8, 3, "2014-01-08", "JFK", "LAX")
  val e = new FlightRaw(2014, 1, 1, 12, 7, "2014-01-12", "JFK", "KBP")
  val f = new FlightRaw(2014, 1, 1, 13, 1, "2014-01-13", "KBP", "LAX")

  val expectedResult: ListBuffer[FlightRaw] = ListBuffer(a, b, c, d, e, f)

  def test1: Boolean = InputManager.readInput("resources/planes_log.csv.gz").toString mustEqual expectedResult.toString

  def test2: Boolean = InputManager.readInput("not_valid_file") mustEqual null

  def test3: Boolean = InputManager.readInput("resources/empty_log.csv.gz") mustEqual ListBuffer()
}