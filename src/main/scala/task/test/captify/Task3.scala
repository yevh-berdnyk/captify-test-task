package task.test.captify

import java.text.SimpleDateFormat
import java.util.{Calendar, GregorianCalendar}

import scala.collection.mutable.ListBuffer

/**
  * List of all airports with total number of planes that arrived to each airport separately per each week
  */
class Task3(flights: ListBuffer[FlightRaw]) extends Task {

  val calendar = new GregorianCalendar()
  val format = new SimpleDateFormat("yyyy-MM-dd")

  override def execute: String = {
    var result = ""
    val flightModels = flights
      .map(flightRaw => new FlightModel(flightRaw, getWeekNumber(flightRaw.fl_date)))
      .groupBy(_.weekNumber)

    flightModels.keys.toArray.sortBy(identity).foreach(week => {
      var dests = new ListBuffer[String]()
      var origins = new ListBuffer[String]()
      flightModels(week).foreach(flight => {
        dests += flight.flightRaw.dest
        origins += flight.flightRaw.origin
      })
      val weekData = TaskCommon.getArrivedPlanes(dests, origins)
      val weekString = weekData.map(_.productIterator.mkString(" ")).mkString("\n ")
      result += s"W$week \n $weekString\n"
    })
    result.trim()
  }

  private def getWeekNumber(flightDate: String): Int = {
    val date = format.parse(flightDate)
    calendar.setTime(date)
    calendar.get(Calendar.WEEK_OF_YEAR)
  }
}

class FlightModel(val flightRaw: FlightRaw, val weekNumber: Int) {

  override def toString = s"\nFlightModel(     $flightRaw, $weekNumber)"
}