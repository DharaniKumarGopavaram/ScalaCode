package FunctionalProgramming.RecursionWithUserInput

import scala.io.StdIn.readInt

object Example1_sumIntegers {
  def main(args : Array[String]) : Unit = {
    print("Enter the number of integers you want to add :- ")
    val noOfIntegers = readInt
    println(s"The sum of the integers you entered is :- ${sumIntegers(noOfIntegers)}")
  }

  private def sumIntegers(n : Int) : Int = {
    if(n < 1) 0
    else {
      print("Enter the integer :- ")
      readInt + sumIntegers(n - 1)
    }
  }
}
