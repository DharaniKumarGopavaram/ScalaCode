package FunctionalProgramming.ScalaConcepts

import java.io.{FileWriter, PrintWriter}
object Chapter16_WritingToAFile {
  def main(args : Array[String]) : Unit = {
    //We need to use Java's printWriter to write content to a file in scala
    val pw = new PrintWriter("/Users/dharani-kumar/Desktop/printWriterFile.txt")
    pw.println("This is the first line to the file from the program")
    pw.println("This is the second line to the file from the program")
    Array("Hello","World").foreach(w => pw.println(w))
    pw.close()
    println("writing the data to printWriterFile is completed ")
    //If we open the file that already exists and try to write the contents they will be overidden
    //If we want to append to the file instead of overwriting we need to use FileWriter along with PrintWriter
    val newPW = new PrintWriter(new FileWriter("/Users/dharani-kumar/Desktop/scannerFile.txt",true))
    newPW.println("500,600.0,Kavya")
    newPW.close()
    println("appending data to the file scannerFile is completed")
  }
}
