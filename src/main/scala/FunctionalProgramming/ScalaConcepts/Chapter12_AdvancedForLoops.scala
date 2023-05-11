package FunctionalProgramming.ScalaConcepts

object Chapter12_AdvancedForLoops {
  def main(args : Array[String]) : Unit = {
    //The yield keyword makes a for loop an expression in Scala
    println("simple yield ")
    val yieldResul1 = for(i <- 1 to 10) yield i
    println(s"yieldResul1 :- $yieldResul1")

    val yieldResult2 = for(i <- 1 to 10) yield i * i
    println(s"yieldResul2 :- $yieldResult2")

    println(s"calling the evalPolyYield function :- ${evalPolyYield(List(3,2,5),2)}")
    //if guards in for loops
    //consider the below for loop
    val yieldResult3 = for(i <- 1 to 10) yield {if(i % 2 == 0) i}
    //In the above for loop we don't have any else condition in the body hence it will return the unit type also the body runs for each iteration
    //We can overcome this situation by placing the if condition in the for loop like below.
    println(s"yieldResult3 :- $yieldResult3")

    val yieldResul4 = for(i <- 1 to 10 ; if i % 2 == 0) yield i
    println(s"yieldResul4 :- $yieldResul4")
    //we can also write the above for loop using flower brackets which improves the readability of the code
    println("for loop with flower brackets")
    val yieldResul5 = for {
      i <- 1 to 10
      if i % 2 == 0
    } yield i * i
    println(s"yieldResul5 :- $yieldResul5")
    println("for loop which returns multiple generators")

    for {
      i <- 1 to 5
      j <- 1 to 5
    } println(s"$i * $j = ${i * j}")
    println("for loop multiple generators with yield")

    val yieldResult6 = for {
      i <- 1 to 10
      j <- 1 to 10
    } yield (i,j)
    println(s"yieldResult6 :- $yieldResult6")

    val yieldResult7 = for {
      i <- 1 to 10
      j <- 1 to 10
    } yield (i,i,i * j)
    println(s"yieldResult7 :- $yieldResult7")

    val yieldResult8 = for {
      i <- 1 to 10
      j <- i to 10 //we can use variable i in the next iteration as well
    } yield (i,j)
    println(s"yieldResult8 :- $yieldResult8")

    //Patterns in for loops
    println("Patterns for loops")
    val tuples = List((1,2),(3,4),(5,6),(7,8),(9,10))
    for((n1,n2) <- tuples) println(s"$n1,$n2") //applying tuple patterns on list of tuples
    for((1,n2) <- tuples) println(s"$n2") //searching for the tuples in the list where first element is 1 and skip the rest of them
    val h :: t = tuples //this pattern is very very important for lists
    println(s"First element of pattern matching :- $h")
    println(s"Rest of the elements using pattern matching :- $t")
    val List(t1,t2,t3,t4,t5) = tuples //another example of pattern matching
    println(s"t1 :- $t1")
    println(s"t2 :- $t2")
    println(s"t3 :- $t3")
    println(s"t4 :- $t4")
    println(s"t5 :- $t5")
    val Array(a,b,c) = "1 2 3".split(" ").map(x => x.toInt)
    println(s"a :- $a")
    println(s"b :- $b")
    println(s"c :- $c")

    val yieldResult9 = for {
      (x,y) <- yieldResult8
      square = x * x + y * y
      if square > 150
    } yield (x,y,square) //we can declare variables in for loop which will avoid us to perform the same computation multiple times
    println(s"yieldResult9 :- $yieldResult9")

    println("Multidimensional for loops using yield")
    val yieldResult10 = for(i <- 1 to 5) yield {
      for(j <- 1 to 5) yield i * j
    }
    println(s"yieldResult10 :- $yieldResult10")

    //If multiple methods are applied on collections like filter, map, take etc., every function we use will create
    //individual collections and take up the memory
    //For example in the below example we are doing filter for over 10M numbers but at the end we are getting only 10 elements out of it
    //(1 to 1000000000).filter(_ %2 == 0).take(10).foreach(println)
    //The above expression will give us OutOfMemoryError since there are too many elements involved
    //We can overcome this by using view which does lazy evaluation
    println("using view on scala collections to perform lazy evaluation :- ")
    (1 to 1000000000).view.filter(_ %2 == 0).take(10).foreach(println)
  }

  ///evalPoly function using yield
  private def evalPolyYield(coeffs : List[Int],x : Int) : Int = {
    val resultVector = for(i <- coeffs.indices) yield coeffs(i) * Math.pow(x,coeffs.length - 1 - i).toInt
    resultVector.sum
  }
}
