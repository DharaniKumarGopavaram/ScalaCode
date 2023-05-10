package RecursionWithUserInput

import scala.io.StdIn.readInt

object Example2_sumUntilNegative {
  def main(args : Array[String]) : Unit = {
    println("This program will add all the integers we specify until a negative number is entered")
    println(s"The sum of the integers you entered is :- ${sumUntilNegative()}")
  }

  private def sumUntilNegative() : Int = {
    print("Enter the integer :- ")
    val input =  readInt
    if(input < 0) 0
    else {
      input + sumUntilNegative()
    }
  }
}
