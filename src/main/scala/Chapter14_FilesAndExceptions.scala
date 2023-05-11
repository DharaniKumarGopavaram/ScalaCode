import java.io.FileNotFoundException
import scala.io.Source

object Chapter14_FilesAndExceptions {
  def main(args : Array[String]) : Unit = {
    try {
      val source = Source.fromFile("/Users/dharani-kumar/Desktop/nums.txt")
      val lines = source.getLines
      try {
        println(s"The sum of the numbers in the file is :- ${lines.filter(x => x.nonEmpty).filter(x => """[0-9]""".r.findFirstIn(x).isDefined).map(x => x.toInt).sum}") //We are filtering for strings that contains only digits
        //In the above expression we are using regular expression. The r method is used to create a regular expression object from the string pattern.
        //Then, the findFirstIn method is used to find the first substring in the input string that matches the pattern. If such a substring is found, findFirstIn returns an Option[String] that is defined (i.e., Some(value)). If no substring matches the pattern, findFirstIn returns None.
        //Finally, the isDefined method is used to check if the Option[String] returned by findFirstIn is defined (i.e., not None). If it is defined, it means the input string contains at least one special character, and containsSpecialCharacters returns true. Otherwise, it returns false.
      }catch {
        case ex : NumberFormatException =>
          println(s"Exception $ex occurred")
          println(s"The file is having non-numeric characters..please correct it")
      }finally {
        source.close()
      }
    } catch {
      case e : FileNotFoundException =>
        println(s"Exception $e occurred")
        println("Please specify the file that exist")
    }

    //we can use Source.fromURL to read data from a web page
  }
}
