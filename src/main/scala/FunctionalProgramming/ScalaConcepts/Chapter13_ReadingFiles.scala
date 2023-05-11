package FunctionalProgramming.ScalaConcepts

import scala.io.Source

object Chapter13_ReadingFiles {
  def main(args : Array[String]) : Unit = {
    val source = Source.fromFile("/Users/dharani-kumar/Desktop/nums.txt") //returns a  BufferedSource object
    println(source.next) //The BufferedSource object by default has the ability to read one character at a time
    println(source.next)
    println(source.hasNext)
    val source2 = source.reset() //If we reset the BufferedSource it returns a new source object which will start from the beginning of the file
    println(source.next) //the source object won't get reset instead it creates a new object which will read from the beginning of the file
    println(source2.next) //returns the first character in the file
    source.close()
    source2.close()
    //We can use getLines method on source to read one line at a time instead of a single character
    val readingAnotherFile = Source.fromFile("/Users/dharani-kumar/Desktop/nums.txt")
    val linesInTheFile = readingAnotherFile.getLines
    println(linesInTheFile.next) //will print one line at a time
    println(linesInTheFile.next)
    println(linesInTheFile.next)
    readingAnotherFile.close()
    val readingNumsFile = Source.fromFile("/Users/dharani-kumar/Desktop/nums.txt")
    val linesInTheNumFile = readingNumsFile.getLines()
    println(s"The sum of numbers in the file is :- ${linesInTheNumFile.filter(_.nonEmpty).map(x => x.toInt).sum}")
    //In the above expression filter(_.nonEmpty) will remove empty lines from the file
  }
}
