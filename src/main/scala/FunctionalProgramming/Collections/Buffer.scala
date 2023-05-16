package FunctionalProgramming.Collections

import scala.collection.mutable
object Buffer {
  def main(args : Array[String]) : Unit = {
    val numBuffer = mutable.Buffer(1,2,3,4,5)
    val randomBuffer = mutable.Buffer.fill(10)(util.Random.nextInt(100))
    println(s"numBuffer :- $numBuffer")
    println(s"randomBuffer :- $randomBuffer")
    numBuffer(3) = 99
    println(s"numBuffer after changing :- $numBuffer")
    numBuffer += 7 += 8 += 9 //unlike Arrays which have fixed size we can add elements to Buffer
    println(s"numBuffer after adding more elements to it :- $numBuffer")
    -20 +=: -10 +=: numBuffer //prepending an element to the Buffer
    println(s"numBuffer after prepending elements :- $numBuffer")
    numBuffer ++= List(1,2,3,4,5) //add all the elements of the collection to the buffer
    println(s"numBuffer after adding collection elements :- $numBuffer")
    numBuffer.insertAll(2,List(100,200,300,400)) //inserting at the specifies position we want
    println(s"numBuffer :- $numBuffer")
    println(s"Dropping elements from numBuffer :- ${numBuffer.drop(2)}")
    println(s"numBuffer after dropping :- $numBuffer") //this doesn't change the original buffer because drop is a method of immutable collection
    println(numBuffer.clear)
    //Some advanced examples of collection
    //We can use collections as functions and can pass them to map and filter functions easily
    Array(7,8,9).map(Array.tabulate(20)(i => i + 1)).foreach(println)
    Array("three","two","one").map(Map("one" -> 1,"two" -> 2, "three" -> 3, "four" -> 4)).foreach(println)
    Array("three","two","one").map(Set("one","three","four")).foreach(println)
  }
}
