object Chapter10_PassByName {
  def main(args : Array[String]) : Unit = {
    //The fill method in scala uses pass by name
    println(incr{
      println("Passing parameters to incr function")
      3 + 4
    })

    println(incrFunc{
      () => {
        println("Passing arguments to the incrFunc function")
        3 + 4
      }
    })

    println(incrByName{println("Passing arguments to the function"); 3 + 4})

    var i = 0
    println(s"Calling the thriceMultiplied function :- ${thriceMultiplied{i += 1; i}}")
    println(s"Calling the thriceMultipliedByName function :- ${thriceMultipliedByName {i += 1;i}}")
    println(s"Calling the threeTupleByName function :- ${threeTupleByName{i += 1; i}}")
    println(s"Calling the threeTupleByName function :- ${threeTupleByName{util.Random.nextInt(100)}}")
  }

  private def incr(i : Int) = {
    println("Start of the incr function")
    i + 1
  }

  //declaring a function which takes a function that has no arguments and returns an Int
  private def incrFunc(i : () => Int) : Int = {
    println("Started the incrFunc function")
    i() + 1
  }

  //In case of incrFunc the function is started first and then the arguments are evaluated for each iteration
  //Another way of writing the above function

  private def incrByName(i: => Int) : Int ={
    println("Starting of the incrByName function")
    i + 1
  }

  private def thriceMultiplied(a : Int) : Int = a * a * a
  private def thriceMultipliedByName(a: => Int) : Int = a * a * a
  private def threeTupleByName(a: => Int) : (Int,Int,Int) = (a,a,a)
}
