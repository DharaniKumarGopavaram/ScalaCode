package FunctionalProgramming.RecursionWithUserInput

import scala.io.StdIn.readLine

object Example4_sumAndCount {
  def main(args : Array[String]) : Unit = {
    println("This program will display the sum and multiplication of integers we specify along with the number of integers we specify")

    println("Enter the integers to perform sum")
    println(s"The sum and the number of integers you specified are :- ${sumAndCount()}")

    println("Enter the integers to perform multiplication")
    println(s"The multiplication and the number of integers you specified are :- ${mulAndCount()}")
  }

  private def sumAndCount() : (Int,Int) = {
    print("Enter the integer :- ")
    val input = readLine
    if(input.toLowerCase.trim == "quit") (0,0)
    else {
      val (result,numCount) = sumAndCount()
      (input.toInt + result, numCount + 1)
    }
  }

  private def mulAndCount() : (Int,Int) = {
    print("Enter the integer :- ")
    val input = readLine
    if (input.toLowerCase.trim == "quit") (1, 0)
    else {
      val (result, numCount) = mulAndCount()
      (input.toInt * result, numCount + 1)
    }
  }

  //The only difference b/w the above two functions is the base case and the operations we perform
  //We can abstract them using the high level functions
}
