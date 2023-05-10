object Chapter9_Currying {
  def main(args : Array[String]) : Unit = {
    //The curried function will take several argument list instead of a single list with multiple arguments
    //We can create curried function in multiple ways
    println("Calling the add function with only one parameter and creating a partially applied function")
    val plus5 = add(5) //When we declare functions like add we can partially call the function with single argument
    println(plus5(6)) //passing the argument to the partially applied function
    println(add(5)(7)) //we can pass 2 arguments directly to the add function like this
    println(s"calling the add2 function :- ${add2(10)(20)}")
    val plus10 = add2(10)_ //creating a partially applied function
    println(plus10(100)) //calling the function with the second argument

    println("Calling the multipleVarArgs method :- ")
    multipleVarArgs("Science","Maths","C++","Java","Python")(90,80,89,92)("Pass","Fail")

    println(normalAdd({println("Hi");100},200))
    //when we define a function with currying we can use code blocks while calling the function
    val result = add2 {
      println("Hi")
      1000} {println("There")
      2000}
    println(s"Calling the add2 function using code blocks and the result is :- $result")
  }

  private def add(x : Int) : Int => Int = y => x + y //add function takes in a parameter and returns a function
  //another way of creating curried function
  private def add2(x : Int)(y : Int) : Int = x + y
  //Let's say if we want to define a function which will take multiple variable length arguments
  //As we know the variable length argument should be the last parameter to the function we can't define it using regular syntax
  //Instead we can use currying to do this
  private def multipleVarArgs(subject : String*)(marks : Int*)(result : String*) : Unit = {
    subject.foreach(println)
    println(marks.sum)
    result.foreach(println)
  }
  private def normalAdd(x: Int, y : Int) = x + y
}
