package FunctionalProgramming.Collections

object Maps {
  def main(args : Array[String]) : Unit = {
    /*
      Map is a collection where we store data in key-value pairs
      We can simply create a Map using Map("One" -> 1, "Two" -> 2, "Three" -> 3)
      We can access the elements using the index with whatever the key type is
      The key type of the Map should be an immutable type
      We can add elements using + and at the same time we can remove elements using -
      We can convert sequence of tuples to map using toMap function
      Maps do not preserve order
    */
    val numMap = Map("One" -> 1, "Two" -> 2, "Three" -> 3)
    println(s"numMap :- $numMap")
    println(s"Accessing the element of a numMap :- ${numMap("Two")}")
    val addingToNumMap = numMap + ("Four" -> 4)
    println(s"Adding element to numMap :- $addingToNumMap")
    val removingFromNumMap = addingToNumMap - "Two"
    println(s"Removing element from numMap :- $removingFromNumMap")
    val numMap2 = Map(10 -> "ten",100 -> "hundred",1000 -> "thousand")
    println(s"numMap2 :- $numMap2")
    println(s"numMap2(10) :- ${numMap2(10)}")
    val newMap = (1 to 100).map(i => i.toString -> i).toMap
    println(s"newMap from sequence of tuples :- $newMap")
    for(t <- newMap.take(5)) println(t) //this prints a tuple
    for((k,v) <- newMap.take(5)) println(s"$k --> $v") //we can use pattern matching capability of for loops to print in the format we require
    newMap.take(5).map(t => t._1 * 2 -> t._2 * 2).foreach(println)
    newMap.take(5).map(t => t._1 * 2).foreach(println)
    newMap.filter(t => t._2 < 5).foreach(println)
    newMap.filter(t => t._1 < "5").foreach(println)
  }
}
