package task.test.captify

import scala.collection.mutable.ListBuffer

/**
  * Non-Zero difference in total number of planes that arrived to and left from the airport
  */
class Task2(dests: ListBuffer[String], origins: ListBuffer[String]) extends Task {

  override def execute: String = {
    val dests_map = dests.groupBy(identity).mapValues(_.size).withDefaultValue(0)
    val origins_map = origins.groupBy(identity).mapValues(_.size).withDefaultValue(0)
    val keys = dests_map.keys.toSet.union(origins_map.keys.toSet)
    val result = keys.map { k => k -> (dests_map(k) - origins_map(k)) }.filter(p => p._2 != 0).toMap
    result.map(_.productIterator.mkString(" ")).mkString("\n")
  }
}