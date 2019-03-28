package task.test.captify

import java.io.{FileInputStream, FileNotFoundException, IOException}
import java.util.zip.{GZIPInputStream, ZipException}

import scala.collection.mutable.ListBuffer
import scala.io.Source

object InputManager {

  def readInput(fileName: String): ListBuffer[FlightRaw] = {
    var flights = new ListBuffer[FlightRaw]()
    try {
      val inputStream = new GZIPInputStream(new FileInputStream(fileName))
      //    drop(1) skips input data header
      for (line <- Source.fromInputStream(inputStream).getLines().drop(1)) {
        flights += convert(line)
      }
      inputStream.close()
      flights
    }
    catch {
      case e@(_: ZipException | _: IOException | _: SecurityException | _: FileNotFoundException | _:
        ArrayIndexOutOfBoundsException) => println(e)
        null
    }
  }

  private def convert(inputLine: String): FlightRaw = {
    val parsed = inputLine.split(",")
    new FlightRaw(
      parsed(0).toInt,
      parsed(1).toInt,
      parsed(2).toInt,
      parsed(3).toInt,
      parsed(4).toInt,
      parsed(5),
      parsed(6),
      parsed(7))
  }
}