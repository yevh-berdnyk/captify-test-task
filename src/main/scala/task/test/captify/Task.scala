package task.test.captify

trait Task {

  def getTaskName: String = this.getClass.getSimpleName

  def execute: String
}