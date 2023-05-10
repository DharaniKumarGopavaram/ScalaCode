package Collections

import scala.io.StdIn.readInt

object Lists {
  def main(args : Array[String]) : Unit = {
    /*
      Arrays aren't the only ways we use to store multiple values in a single variable
      We have lists which also does the same but varies a lot with arrays
      Lists are zero index based
      Lists are immutable
      To prepend an element to the List use cons(::) operator
      Just like arrays we can access the elements using index
      Lists will work good if we don't the number of elements upfront
    */
    val sampleList = List(5,4,2,3,1) //simple way of creating list
    println(s"The original list :- $sampleList")
    //The cons(::) operator is a right associativity operator meaning if we write 10 :: sampleList it will get converted as sampleList.::(10)
    println(s"Prepending the value 99 to the original list using :: operator :- ${99 :: sampleList}")
    val emptyList = Nil //We can use Nil to create an empty list
    println(s"Empty List :- $emptyList")
    val prependList = 10 :: 20 :: 30 :: 40 :: Nil
    println(s"List which was created using cons and Nil :- $prependList")
    println(s"Accessing elements using index sampleList(1) :- ${sampleList(1)}")
    println(s"The head method gives the first element of the list :- ${sampleList.head}")
    println(s"The tail method gives all the elements in the list except the first element :- ${sampleList.tail}")

    //Take the number of integers you want to add and take input from the user and create list
    print("Enter the number of elements you want to add to list :- ")
    val noOfElements = readInt
    val outputList = createUserList(noOfElements)
    println(s"The list with the elements you entered is :- $outputList")

    println(s"Performing addition of the elements you entered :- ${operateOnLists(outputList,0,_ + _)}")
    println(s"Performing multiplication of the elements you entered :- ${operateOnLists(outputList,1,_ * _)}")
    println(s"Finding minimum of the elements you entered :- ${operateOnLists(outputList,Int.MaxValue,_ min _)}")
    println(s"Finding maximum of the elements you entered :- ${operateOnLists(outputList,Int.MinValue,_ max _)}")

    println(s"Performing addition of the elements you entered :- ${operateOnListsMatch(outputList, 0, _ + _)}")
    println(s"Performing multiplication of the elements you entered :- ${operateOnListsMatch(outputList, 1, _ * _)}")
    println(s"Finding minimum of the elements you entered :- ${operateOnListsMatch(outputList, Int.MaxValue, _ min _)}")
    println(s"Finding maximum of the elements you entered :- ${operateOnListsMatch(outputList, Int.MinValue, _ max _)}")

    /*
      fill method :- We can use fill method to create Lists/Arrays
      fill method takes two arguments
      First argument is the length of the array/list we want to create
      Second argument is the value to be filled in the array which gets evaluated for each iteration
    */

    println(s"fill method example 1 -- List.fill(10)(5) :- ${List.fill(10)(5)}")
    println(s"fill method example 2 -- List.fill(10)(Math.random) :- ${List.fill(10)(Math.random)}")
    var i = 0
    println(s"fill method example 3 -- List.fill(10)({i += 1; i}) :- ${List.fill(10)({i += 1; i})}")
    println(s"""fill method example 4 -- List.fill(10)({print("Enter the integer :- ");readInt}) :- ${List.fill(3)({print("Enter the integer :- ");readInt})} """)

    /*
      tabulate method :- tabulate method is same like fill except the second argument is a function
      The parameter we get on each iteration is the index for the array
    */

    println(s"Tabulate method example 1 -- List.tabulate(10)(i => i) :- ${List.tabulate(10)(i => i)}")
    println(s"Tabulate method example 2 -- List.tabulate(10)(i => i + 1) :- ${List.tabulate(10)(i => i + 1)}")
    println(s"Tabulate method example 3 -- List.tabulate(10)(_ * 2) :- ${List.tabulate(10)(_ * 2)}") //we can underscore notation as well
    println(s"Tabulate method example 4 -- List.tabulate(10)(i => 7) :- ${List.tabulate(10)(i => 7)}") //we can completely ignore the index as well

  }

  private def createUserList(n : Int) : List[Int] = {
    if(n == 0) Nil
    else {
      print("Enter the integer :- ")
      readInt :: createUserList(n - 1)
    }
  }

  private def operateOnLists(lst : List[Int], base : Int, f : (Int,Int) => Int) : Int = {
    if(lst == Nil) base
    else f(lst.head,operateOnLists(lst.tail,base,f))
  }

  //The above function using match expression which is having pattern matching
  private def operateOnListsMatch(lst : List[Int], base : Int, f : (Int,Int) => Int) : Int = lst match {
    case Nil => base
    case h :: t => f(h,operateOnListsMatch(t,base,f)) //This is pattern matching which is very useful in case of lists
  }
}
