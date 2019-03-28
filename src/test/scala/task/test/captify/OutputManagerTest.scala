package task.test.captify

import org.specs2.mutable.Specification

import scala.io.{BufferedSource, Source}

class OutputManagerTest extends Specification {

  override def is =
    s2"""
      This is spec for OutputManager
      Check that writeOutput method returns true: $test1
      Check content of an output file: $test2
  """

  val folderName = "testFolder"
  val fileName = "testFile"
  val content = "content"
  val write: Boolean = OutputManager.writeOutput(folderName, fileName, content)

  def test1: Boolean = write mustEqual true

  def test2: Boolean = {
    val source: BufferedSource = Source.fromFile(s"output/$folderName/$fileName.txt")
    val result = source.mkString mustEqual content
    source.close()
    result
  }
}