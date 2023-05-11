import scala.io.Source
import java.io.File
object Chapter19_ReadingDataFromMultipleFiles {
  def main(args : Array[String]) : Unit = {
      val directory : File = new File("/Users/dharani-kumar/Desktop/Real_Learning/AWS/Data/namesbystate")
      val nameToBeSearched = "John"
      var maximum : Int = 0
      var fileName : String = ""
      directory.listFiles.filter(x => x.isFile && x.toString.endsWith("TXT")).map(x => x.toString).foreach {
        file => {
          val source = Source.fromFile(file)
          val maxTimes = source.getLines.filter(x => x.split(",")(3) == nameToBeSearched).map(x => x.split(",")(4).toInt).max
          if(maxTimes > maximum) {
            maximum = maxTimes
            fileName = file
          }
        }
      }
      println(s"The maximum times the $nameToBeSearched appeared in all the files is $maximum and it appeared in the file $fileName")
      Source.fromFile(fileName).getLines.map(x => x.split(",")).filter(x => x(3) == nameToBeSearched && x(4).toInt == maximum).foreach(a => println(a.mkString(",")))
  }
}
