package FunctionalProgramming.ScalaConcepts

import scala.annotation.tailrec

object Chapter4_Recursion {
  def main(args : Array[String]) : Unit = {
    /*
      A function calling itself is called recursive function
      Every recursive function should have a base case which tells when to stop calling the function
      We must specify the return type for a recursive function
      There are two types of recursion :- normal recursion and tail recursion
      In normal recursion, a function calls itself and does not return any value until the base case is reached, which is the stopping condition for the recursion. Each recursive call creates a new stack frame on the call stack, which can lead to a stack overflow if the recursion depth is too large.
      In contrast, tail recursion is a type of recursion where the recursive call is the last operation performed in the function, and the result of the recursive call is immediately returned. This means that there is no need to create a new stack frame for the recursive call since the current stack frame can be reused. This makes tail recursion more efficient and avoids the risk of stack overflow.
    */
    println(s"Calling the factReturnInt function with 8 as parameter and the result is :- ${factReturnInt(8)} ")
    println(s"Calling the factTailRecursion function with (8,1) as parameters and the result is :- ${factTailRecursion(8,1)} ")
    //When we pass 17 as the parameter to the factReturnInt it gives negative result this is because Int is only 32 bits
    println(s"Calling the factReturnInt function with 17 as parameter and the result is :- ${factReturnInt(17)} ")
    //If we change the return type to Long then it will give the correct results
    println(s"Calling the factReturnLong function with 17 as parameter and the result is :- ${factReturnLong(17)} ")
    //Sometimes Long also won't be able to hold the large values in this case we can use BigInt which can hold any number
    println(s"Calling the factReturnLong function with 54 as parameter and the result is :- ${factReturnLong(54)} ")
    //BigInt will give us correct results but it is a bit slow
    println(s"Calling the factReturnBigInt function with 54 as parameter and the result is :- ${factReturnBigInt(54)} ")
    println(s"Calling the squareSumNumbers function with 10 as parameter and the result is :- ${squareSumNumbers(10)}")
    println(s"Calling the countDown function with 10 as parameter and the result is below :- ")
    countDown(10)
    println(s"Calling the countFromTo function with 17 and 30 as parameters and the result is below :- ")
    countFromTo(17,30)
  }

  //This factorial function is written using normal recursion
  private def factReturnInt(n : Int) : Int = if(n < 2) 1 else n * factReturnInt(n -1)
  private def factReturnLong(n : Int) : Long = if(n < 2) 1L else n * factReturnLong(n - 1)
  private def factReturnBigInt(n : Int) : BigInt = if(n < 2) 1 else n * factReturnBigInt(n - 1)

  //Writing the factorial function using tail recursion
  /*
    @tailrec we used below is an scala annotation
    Scala annotations are a way to add metadata to classes, methods, and other program elements in Scala code.
    Annotations provide additional information that can be used by compilers, run-time systems, and other tools to customize the behavior of a program or generate additional code.
  */
  @tailrec
  private def factTailRecursion(n : Int,value : Int) : Int = {
    if(n == 1) value
    else factTailRecursion(n - 1,value * n)
  }

  private def squareSumNumbers(n  : Int) : Int = if(n < 1) 0 else n * n + squareSumNumbers(n - 1)

  @tailrec
  private def countDown(n : Int) : Unit = if(n > 0) {
    println(n)
    countDown(n - 1)
  }

  @tailrec
  private def countFromTo(from : Int,to : Int) : Unit = {
    if(from <= to) {
      println(from)
      countFromTo(from + 1,to)
    }
  }
}
