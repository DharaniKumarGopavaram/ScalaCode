import java.io.PrintWriter
import scala.io.Source

object Chapter17_ReadingAndWritingToAFile {
  def main(args: Array[String]): Unit = {
      val source = Source.fromFile("/Users/dharani-kumar/Desktop/Real_Learning/AWS/Data/namesbystate/NY.TXT")
      val nameToBeSearched = "Mark"
      val pw = new PrintWriter("/Users/dharani-kumar/Desktop/" + nameToBeSearched + ".txt")
      val filteredData = source.getLines.toList.filter(x => x.split(",")(3) == nameToBeSearched)
      filteredData.foreach(x => pw.println(x))
      source.close()
      pw.close()
  }
}
