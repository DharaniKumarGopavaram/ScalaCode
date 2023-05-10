package RecursionWithUserInput

import scala.io.StdIn.readLine

object Example3_sumUntilQuit {
  def main(args : Array[String]) : Unit = {
    println("This program will add all the integers we specify until we enter quit")
    println(s"The sum of the integers you entered is :- ${sumUntilQuit()}")
  }

  private def sumUntilQuit() : Int = {
    print("Enter the integer :- ")
    val input = readLine
    if(input.toLowerCase.trim == "quit") 0
    else {
      input.toInt + sumUntilQuit()
    }
  }
}
