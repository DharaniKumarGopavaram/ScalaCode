package Collections

import scala.annotation.tailrec

object Arrays {
  def main(args : Array[String]) : Unit = {
    /*
      Array is a collection which can hold multiple values in a single variable
      Arrays are mutable
      Arrays are zero index based
      Once we create an Array the length of the array remains constant we cannot change it we can change the values though
      We will use arrays when we know the number of elements upfront
    */
    val a = Array(7,5,3,9,6,1,2) //The simplest way to create an array
    val b = Array[Int](10,20,30,40) //We can explicitly specify the type if we want to
    println(s"Accessing the first element of the array using index ${a(0)}")
    println(s"Accessing the second element of the array using index ${a(1)}")
    //If we specify the index that doesn't exist we get ArrayIndexOutOfBoundsException
    println(s"Length of the array is :- ${a.length}")
    println(s"Original Array before changing it :- ${a.mkString(",")}")
    println("Modifying the value of the 3rd element in the array")
    a(2) = 99
    println(s"Mutated Array :- ${a.mkString(",")}")
    val onesArray = Array(1,1,1,1,1)
    println(s"Ones Array before calling the function :- ${onesArray.mkString(",")}")
    fillArray(onesArray,0,99)
    println(s"Ones Array after calling the function :- ${onesArray.mkString(",")}")

    val numbersArray = Array(7,5,3,9,6,1,2)
    println(s"Calling the operateOnArray function for addition :- ${operateOnArray(numbersArray,0,_ + _)}")
    println(s"Calling the operateOnArray function for addition :- ${operateOnArray(numbersArray,0,_ * _)}")
    println(s"Calling the operateOnArray function for addition :- ${operateOnArray(numbersArray,0,_ max _)}")
    println(s"Calling the operateOnArray function for addition :- ${operateOnArray(numbersArray,0,_ min _)}")
  }

  //The below function will take an Array as a parameter and change all the values
  @tailrec
  private def fillArray(arr : Array[Int],i : Int,v : Int) : Unit = {
    if(i < arr.length) {
      arr(i) = v
      fillArray(arr,i + 1,v)
    }
  }

  //The below function will perform several arithmetic operations on array elements
  private def operateOnArray(arr : Array[Int],i : Int,f : (Int,Int) => Int) : Int = {
    if (i == arr.length - 1) arr(i)
    else f(arr(i), operateOnArray(arr, i + 1, f))
  }
}
