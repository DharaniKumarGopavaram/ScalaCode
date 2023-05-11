package FunctionalProgramming.ScalaConcepts

object Chapter7_OptionType {
  def main(args : Array[String]) : Unit = {
    /*
      The option type in scala represents some thing that may or may not have a value
      There will be some methods for collection types which returns Option type so we need to understand this
      One example of such function is find which takes a boolean function as parameter and returns the first element that satisfies the condition
    */
    val sampleList = List(7, 5, 2, 1, 6, 3, 1, 9)
    val result1 = sampleList.find(_ > 10)
    println("get method with try/catch")
    try {
      println(result1.get) //If there is no element that satisfies the condition we specify and if we try to use get method we get Exception
    } catch {
      case e : NoSuchElementException =>
          println("Exception occurred since you are trying to access a element that doesn't exist")
    }
    val result2 = sampleList.find(_ < 9)
    println(result2.get)
    //Instead of get method which will give NoSuchElementException we can use getOrElse method
    println("getOrElse method :- ")
    println(sampleList.find(_ > 10).getOrElse("Data not found"))
    println(sampleList.find(_ > 8).getOrElse("Data not found"))
    //We can use map function like below on Option type
    println("using map function on the Option Type")
    println(sampleList.find(_ > 10).map(_ * 2)) //map method doesn't return any error if the element doesn't exist
    println(sampleList.find(_ > 8).map(_ * 2)) //when the value is present map returns the correct value
    println("Using match expression on the Option Type")
    sampleList.find(_ > 8) match { //we can use match expression like this on Option type
      case Some(n) => println(n * 2)
      case None => println(0)
    }
    sampleList.find(_ > 10) match {
      case Some(n) => println(n * 2)
      case None => println(0)
    }
    println("using if condition on the Option type")
    val finalResult = sampleList.find(_ > 10)
    if(finalResult.nonEmpty) println(finalResult.get * 2) else println(0)

  }
}
