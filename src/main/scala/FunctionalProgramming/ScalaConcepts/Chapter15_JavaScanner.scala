package FunctionalProgramming.ScalaConcepts

import java.io.File
import java.util.Scanner

object Chapter15_JavaScanner {
  def main(args : Array[String]) : Unit = {
    //Instead of using scala.io.Source to read a file we can also use Java scanner class which has more methods like hasNextLine, nextInt, nextDouble etc.,
    //We can accomplish every requirement with Source but in case if we want to use Java scanner we can use it.
    val source = new Scanner(new File("/Users/dharani-kumar/Desktop/scannerFile.txt")).useDelimiter("[\n,]")
    while(source.hasNext) {
      println(s"${source.nextInt},${source.nextDouble},${source.next}")
    }
  }
}
