package task.test.captify

import java.io.{File, FileNotFoundException, PrintWriter}

object OutputManager {

  def writeOutput(folderName: String, fileName: String, content: String): Boolean = {
    try {
      new File(s"output/$folderName").mkdirs()
      new PrintWriter(s"output/$folderName/$fileName.txt") {
        write(content)
        close()
      }
      true
    }
    catch {
      case e@(_: SecurityException | _: FileNotFoundException) => println(e)
        false
    }
  }
}