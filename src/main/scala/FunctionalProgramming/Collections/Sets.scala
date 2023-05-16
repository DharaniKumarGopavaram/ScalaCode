package FunctionalProgramming.Collections

import scala.collection.mutable
object Sets {
  def main(args : Array[String]) : Unit = {
    /*
      With sets order doesn't matter and sets doesn't allow duplicates
      Simply way to create Set is Set(1,2,3)
      When we create Set like this the default Set we get is an Immutable Set
      We can add elements to Set using + and we can remove elements from Set using -
      The indexing in Sets will let us know once the element is present or not in the Set but in other collections it will return the value at the specified index
      When we index into the sets we are actually calling the apply method of the set object
      All the normal collection functions like map, filter, foreach will work on sets
      We can use sets when we want to know whether the element is available in the collection or not
      So if we are using contains method a lot then we should use sets
    */
    val s1 = Set(1,2,3)
    println(s"Original Set :- $s1")
    val s2 = s1 + 4
    println(s"Adding element 4 to set :- $s2")
    val s3 = s2 + -10
    println(s"Adding element -10 to set :- $s3")
    val s4 = s3 - 2
    println(s"Removing element 2 from set :- $s4")
    println(s"Checking for element 4 in the Set :- ${s4(4)}")
    println(s"Checking for element 99 in the Set :- ${s4(99)}")
    val strSet = Set("this","is","a","test")
    println(s"checking whether the element is present or not in the set :- ${strSet("is")}")
    println(s"checking whether the element is present or not in the set :- ${strSet("Dharani")}")
    println(s"Iterating through all the elements in the Set using foreach")
    s3.foreach(println)
    println(s"using map and filter method on sets :- ${s3.map(_ * 2).filter(_ > 0).mkString(",")}")
    println("using for loops on sets :- ")
    for(s <- s3) println(s)

    //Mutable Set functions
    val mutableSet = mutable.Set(1,2,3,4)
    println(s"original mutable set :- $mutableSet")
    println(s"adding element -10 to the set :- ${mutableSet + -10}")
    println(s"the original set is not changed :- $mutableSet") //this is because + method is available for immutable collections as well
    println(s"mutating the set by adding -10 to it using += method :- ${mutableSet += -10}") //If we use += method the original set gets mutated
    println(s"the original set is changed :- $mutableSet")
    println(s"removing element 3 from set using -= method :- ${mutableSet -= 3}")
    println(s"Chaining the += and -= methods on set :- ${mutableSet += 5 += 25 += 98 -= 90 -= 25}")
    println(s"adding all the elements of a list to the set using ++= method :- ${mutableSet ++= List(11,12,13,14,15)}")
    println(s"using add method to add element to set :- ")
    println(mutableSet.add(111)) //Like += and ++= methods the add method doesn't return the set instead it returns boolean which tells whether the element got added or not to the collection
    println(mutableSet.add(11)) //since 11 already exist and as Sets doesn't allow duplicates this returns false
    println(s"using remove method to remove elements from set :- ")
    println(mutableSet.remove(12))
    println(mutableSet.remove(99))
    println(mutableSet)
    println(mutableSet.clear()) //clears all the elements from the set
    val rangeSet = mutable.Set[Int]()
    rangeSet ++= 1 to 20
    println(s"Range Set :- $rangeSet")
    println(s"applying filter method on range set :- ${rangeSet.filter(_ % 2 == 0)}") //filter method doesn't mutate the original collection instead it creates a new one
    println(s"original set is not changed :- $rangeSet")
    println(s"Adding elements using indexing :-")
    rangeSet(30) = true
    println(s"original set after adding using indexing :- $rangeSet")
    println("Removing elements using indexing :- ")
    rangeSet(4) = false
    println(s"original set after removing using indexing :- $rangeSet")
  }
}
