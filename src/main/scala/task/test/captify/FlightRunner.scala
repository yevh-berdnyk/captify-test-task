package task.test.captify

import scala.collection.mutable.ListBuffer

object FlightRunner {

  def start(): Unit = {
    processFile("resources/planes_log.csv.gz")
  }

  def processFile(fileName: String): Unit = {
    val flights = InputManager.readInput(fileName)
    if (flights == null) {
      println("Planes log data was not generated")
      return
    }

    var dests = new ListBuffer[String]()
    var origins = new ListBuffer[String]()

    flights.foreach(flight => {
      dests += flight.dest
      origins += flight.origin
    })

    val tasks = Array(
      new Task1(dests, origins),
      new Task2(dests, origins),
      new Task3(flights)
    )

    val timeStamp = System.currentTimeMillis()
    tasks.foreach(task => {
      val output = task.execute
      OutputManager.writeOutput(timeStamp.toString, task.getTaskName, output)
    })
  }
}