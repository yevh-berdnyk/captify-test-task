package task.test.captify

import java.io.File

import org.specs2.mutable.Specification
import org.specs2.specification.BeforeEach
import org.specs2.specification.core.SpecStructure

import scala.io.{BufferedSource, Source}
import scala.reflect.io.Directory

class FlightRunnerTest extends Specification with BeforeEach {

  override protected def before: Any = {
    val directory = new Directory(new File("output"))
    directory.deleteRecursively()
  }

  override def is: SpecStructure = sequential ^
    s2"""
         This is spec for FlightRunner
         Check that correct input file produces expected output files: $test1
         Check that empty input file produces empty output files: $test2
         Check that non-existing input file doesn't produce output files: $test3
      """

  def test1: Boolean = {
    FlightRunner.processFile("resources/planes_log.csv.gz")
    val folderName: String = new File("output").list()(0)

    val content1: String = "KBP 2\nLAX 4\nJFK 0"
    val content2: String = "LAX 4\nJFK -4"
    val content3: String = "W1 \n LAX 1\n JFK 0\nW2 \n KBP 1\n LAX 2\n JFK 0\nW3 \n KBP 1\n LAX 1\n JFK 0"

    val source1: BufferedSource = Source.fromFile(s"output/$folderName/Task1.txt")
    val source2: BufferedSource = Source.fromFile(s"output/$folderName/Task2.txt")
    val source3: BufferedSource = Source.fromFile(s"output/$folderName/Task3.txt")

    val result1 = source1.mkString mustEqual content1
    val result2 = source2.mkString mustEqual content2
    val result3 = source3.mkString mustEqual content3

    source1.close()
    source2.close()
    source3.close()

    result1
    result2
    result3
  }

  def test2: Boolean = {
    FlightRunner.processFile("resources/empty_log.csv.gz")
    val folderName: String = new File("output").list()(0)

    val source1: BufferedSource = Source.fromFile(s"output/$folderName/Task1.txt")
    val source2: BufferedSource = Source.fromFile(s"output/$folderName/Task2.txt")
    val source3: BufferedSource = Source.fromFile(s"output/$folderName/Task3.txt")

    val result1 = source1.mkString mustEqual ""
    val result2 = source2.mkString mustEqual ""
    val result3 = source3.mkString mustEqual ""

    source1.close()
    source2.close()
    source3.close()

    result1
    result2
    result3
  }

  def test3: Boolean = {
    FlightRunner.processFile("not_valid_file")
    !new Directory(new File("output")).exists
  }
}