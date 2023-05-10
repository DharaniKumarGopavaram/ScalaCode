object Chapter5_matchExpression {
  def main(args : Array[String]) : Unit = {
    /*
      The syntax of match expression is
      expression match {
          case pattern1 =>
          case pattern2 =>
      }
    */
    println(s"Calling the factMatchExpression by passing 7 as the parameter and the result is ${factMatchExpression(7)} ")

    //If we pass negative number to the factMatchExpression function we will get StackOverFlow Error
    //We can avoid this situation using the if guards
    println(s"Calling the factMatchExpression by passing 7 as the parameter and the result is ${factMatchIfGuard(7)} ")
    println("Negative number check")
    println(s"Calling the factMatchExpression by passing -10 as the parameter and the result is ${factMatchIfGuard(-10)} ")

    //Recursive Fizz Buzz
    //If the number is divided by 3 we will say fizz, else if the number is divided by 5 we will say buzz if the number is divided by both 3 and 5 we will say fizz buzz.
    println(s"Calling the recursiveFizzBuzz function passing 0 as the parameter and the result is below :- ")
    recursiveFizzBuzz(0)
  }

  //converting the factorial to use match expression
  private def factMatchExpression(n : Int) : Int = n match {
    case 2 => 2
    case _ => n * factMatchExpression(n - 1)
  }

  private def factMatchIfGuard(n : Int) : Int = n match {
    case 2 => 2
    case x if x > 0 => n * factMatchIfGuard(n - 1)
    case _ => -1
  }

  private def recursiveFizzBuzz(n : Int) : Unit = {
    if(n <= 100) {
      (n % 3, n % 5) match {
        case (0,0) => println("Fizz Buzz")
        case (0,_) => println("Fizz")
        case (_,0) => println("Buzz")
        case (_,_) => println(n)
      }
      recursiveFizzBuzz(n + 1)
    }
  }
}
