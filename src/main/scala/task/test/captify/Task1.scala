package task.test.captify

import scala.collection.mutable.ListBuffer

/**
  * List of all airports with total number of planes for the whole period that arrived to each airport
  */
class Task1(dests: ListBuffer[String], origins: ListBuffer[String]) extends Task {

  override def execute: String = {
    val result = TaskCommon.getArrivedPlanes(dests, origins)
    result.map(_.productIterator.mkString(" ")).mkString("\n")
  }
}