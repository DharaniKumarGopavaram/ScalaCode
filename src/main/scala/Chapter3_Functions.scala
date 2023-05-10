object Chapter3_Functions {

  private type Vector3 = (Int,Int,Int)

  def main(args : Array[String]) : Unit = {
    //Function definition starts with def Every argument to a function should have a type associated with it
    //The return type of the function is optional scala can figure out on its own but it is a good practice to specify the return type
    println(s"Calling the square function by passing parameter 10 :- ${square(10)}")
    println(s"Calling the someLogic function by passing parameter 10,2 :- ${someLogic(10,2)}")
    println(s"Calling the greet procedure which returns unit :- ${greet("Dharani")}")

    //Side effects in Scala are those which change the value of a variable or print the output to a console or read input from the user inside a function
    //A function whose return type is Unit is called procedure in scala

    //A function literal is alternate syntax for defining a function
    //It's useful when you want to pass function as an argument to a method(especially a higher order method like fold of filter) but we don't want to define a separate function
    //Function literals are anonymous they don't have a name by default but we can give them a name by binding them to a variable

    val lambdaSquareFn = (x : Int) => x * x
    println(s"Calling the lambdaSquareFn by passing 10 as parameter :- ${lambdaSquareFn(10)}")

    val lambdaSumFn = (x : Int, y : Int) => x + y
    println(s"Calling the lambdaSumFn by passing 100 and 200 as parameters :- ${lambdaSumFn(100,200)}")

    //When the parameter we pass to the lambda function is used only once inside the function body then we can use underscore notation like this
    val lambdaDoubleUnderscoreFn = (_:Int) * 2
    println(s"Calling the lambdaDoubleUnderscoreFn by passing 10 as parameter :- ${lambdaDoubleUnderscoreFn(10)}")

    //other way of using underscore notation
    val lambdaSumUnderScoreFn : (Int,Int) => Int = _ + _
    println(s"Calling the lambdaSumUnderScoreFn by passing 1000 and 2000 as parameters :- ${lambdaSumUnderScoreFn(1000,2000)}")

    //Higher order functions are functions that can take functions as arguments and return functions.
    //Let's say we have 3 functions to perform sum, multiplication and min on 3 Integers.
    //We will write the functions like this.
    println(s"Calling the sum3 function by passing 10,20,30 as parameters :- ${sum3(10,20,30)}")
    println(s"Calling the mul3 function by passing 10,20,30 as parameters :- ${mul3(10,20,30)}")
    println(s"Calling the min3 function by passing 10,20,30 as parameters :- ${min3(10,20,30)}")

    //Instead of writing 3 functions what if we write a function that takes a lambda function as an argument and perform all the operations in the function itself
    println(s"Calling the combine3 function for sum :- ${combine3(10,20,30,(x,y) => x + y)}")
    println(s"Calling the combine3 function for multiplication :- ${combine3(10,20,30,(x,y) => x * y)}")
    println(s"Calling the combine3 function for min :- ${combine3(10,20,30,(x,y) => x min y)}")
    println(s"Calling the combine3 function for max :- ${combine3(5,7,9,_ max _)}") //we can use underscore notation as well

    println(s"Calling the addVector function by passing parameters (10,20,30) and (40,50,60) and the result is :- ${addVector((10,20,30),(40,50,60))}")
    println(s"Calling the optimisedAddVector function by passing parameters (10,20,30) and (40,50,60) and the result is :- ${optimisedAddVector((10,20,30),(40,50,60))}")

    println("Calling the function with variable length arguments")
    println(s"average function average(10,20,30,40) :- ${average(10,20,30,40)}")
    println(s"average function average(10,20,30,40,50,60,70,80,90) :- ${average(10,20,30,40,50,60,70,80,90)}")
    println(s"average function average() :- ${average()}") //This returns NaN(Not a Number)
    //To overcome we can alter out function a bit
    println(s"goodAverage function goodAverage(10,20,30,40) :- ${goodAverage(10, 20, 30, 40)}")
    println(s"goodAverage function goodAverage(10,20,30,40,50,60,70,80,90) :- ${goodAverage(10, 20, 30, 40, 50, 60, 70, 80, 90)}")
    println(s"goodAverage function goodAverage() :- ${goodAverage()}")
    //We can use collections instead of variable length arguments but the code will be a bit verbose
    println(s"averageList function averageList(10,20,30,40,50,60,70,80,90) :- ${averageList(List(10, 20, 30, 40, 50, 60, 70, 80, 90))}")
    //Passing the list of values to a variable length arguments function
    val sampleList = List(10,20,30,40,50,60,70,80,90)
    println(s"Passing list of values to a variable length arguments function :- ${goodAverage(sampleList:_*)}")
  }

  private def square(x : Int) = x * x
  private def someLogic(x : Int, y : Int) = 4 * x - 2 * y
  private def greet(name : String) : Unit = println(s"Hello $name")
  private def sum3(x : Int, y : Int, z : Int) : Int  = x + y + z
  private def mul3(x : Int, y : Int, z : Int) : Int  = x * y * z
  private def min3(x : Int, y : Int, z : Int) : Int  = x min y min z
  private def combine3(x : Int, y : Int, z : Int, f : (Int,Int) => Int) = f(f(x,y),z)

  //Below type of functions are hard to read because of long list of tuples
  //To overcome this issue we can define a type and use it
  private def addVector(v1 : (Int,Int,Int), v2 : (Int,Int,Int)) : (Int,Int,Int) = {
    (v1._1 + v2._1,v1._2 + v2._2,v1._3 + v2._3)
  }

  private def optimisedAddVector(v1 : Vector3,v2 : Vector3) : Vector3 = {
    (v1._1 + v2._1,v1._2 + v2._2,v1._3 + v2._3)
  }

  //The arguments of a function can accept any number of values such types of arguments are called variable length arguments
  //If we define a function with variable length arguments we can call the function with any number of values we want
  private def average(nums : Int*) : Double = nums.sum / nums.length.toDouble
  private def goodAverage(nums : Int*) : Double = if(nums.nonEmpty) nums.sum.toDouble / nums.length else 0.0

  //Without using variable length arguments we can define the above functions using collections
  private def averageList(lst : List[Int]) : Double = if(lst.nonEmpty) lst.sum.toDouble / lst.length else 0.0
}
