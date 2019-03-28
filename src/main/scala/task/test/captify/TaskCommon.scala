package task.test.captify

import scala.collection.mutable.ListBuffer

object TaskCommon {

  def getArrivedPlanes(dests: ListBuffer[String], origins: ListBuffer[String]): Map[String, Int] = {
    var result = dests.groupBy(identity).mapValues(_.size)
    origins.distinct.foreach(origin => {
      if (!dests.contains(origin)) {
        result += (origin -> 0)
      }
    })
    result
  }
}