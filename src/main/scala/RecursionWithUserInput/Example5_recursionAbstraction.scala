package RecursionWithUserInput

import scala.io.StdIn.readLine

object Example5_recursionAbstraction {
  def main(args : Array[String]) : Unit = {
    println("This program explains the abstraction of recursion")

    println("Calling the combineRecursive for addition")
    println(s"The sum and the number of the integers you specified is :- ${combineRecursive(0,_ + _)}")

    println("Calling the combineRecursive for multiplication")
    println(s"The product and the number of the integers you specified is :- ${combineRecursive(1, _ * _)}")

    println("Calling the combineRecursive to get the minimum number")
    println(s"The minimum number and the overall number of the integers you specified is :- ${combineRecursive(Int.MaxValue, _ min _)}")
  }

  private def combineRecursive(base : Int,op : (Int,Int) => Int) : (Int,Int) = {
    print("Enter the integer :- ")
    val input = readLine
    if(input.toLowerCase.trim == "quit") (base,0)
    else {
      val (result,numCount) = combineRecursive(base,op)
      (op(input.toInt,result),numCount + 1)
    }
  }
}
