package FunctionalProgramming.ScalaConcepts

import scala.io.StdIn.readLine

object Chapter11_Loops {
  def main(args : Array[String]) : Unit = {
    //While loop
    //While loop can only be used as a statement and it returns unit type
    //We have do-while loop as well which is rarely used
    //While loop is a pre-check loop while do while is post check loop
    var i = 0
    println("while loop :- ")
    while(i <= 10) {
      println(i)
      i += 1
    }
    println("using while loop to read list of integers from user and prepare a list out of it")
    print("Enter an integer :- ")
    var input = readLine.toLowerCase.trim
    var lst = List[Int]()
    while(input != "quit") {
      lst ::= input.toInt
      print("Enter an integer :- ")
      input = readLine.toLowerCase.trim
    }
    println(lst.reverse)
    //for loops
    //for loops are actually foreach loop on collection. The collection we normally use with for loop is called Range
    println("for loops :- ")
    println("for loop with to")
    for(i <- 1 to 10) println(i)
    println("for loop with until")
    for(i <- 1 until 10) println(i)
    println("for loop on collections")
    for(i <- List(10,20,30,40)) println(i)
    println("for loop on character range type")
    for(i <- 'a' to 'z') println(i)
    println("for loop on long range type")
    for(i <- 1L to 10L) println(i)
    println("for loop in reverse order")
    for(i <- 10 to 1 by -1) println(i)
    println("one more type of for loop")
    for(i <-  1 to 20 by 5) println(i)
    println(s"calling the evalPoly function :- ${evalPoly(List(3,2,5),2)}")
    println(s"calling the betterEvalPoly function :- ${betterEvalPoly(List(3,2,5),2)}")
  }

  private def evalPoly(coeffs : List[Int] , x  : Int ) : Int = {
    var sum = 0
    for(i <- coeffs.indices) { //indices method will return all the indexes in the collection
      sum += coeffs(i) * Math.pow(x,coeffs.length - 1 - i).toInt
    }
    sum
  }

  private def betterEvalPoly(coeffs : List[Int], x  : Int) : Int = {
    var sum = 0
    var power = 1
    for(i <- coeffs.reverse) {
      sum += power * i
      power *= x
    }
    sum
  }
}
