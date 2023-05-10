object Chapter1_ScalaBasics {
  def main(args : Array[String]) : Unit = {
    /*

    Scala is very much object oriented programming language
    Every value in scala is an object
    We call methods of objects using dot notation
    There are no operators in Scala hence +, -, / and * are methods

    */
    println("Hello World")
    println("Converting Double to Int 5.6.toInt :- " + 5.6.toInt) //converting Double to Int
    println("Converting Int to Double 5.toDouble :- " + 5.toDouble) //converting Int to Double
    println("Calling the method + on Int object 4 by passing parameter as 10 -- 4.+(10) :- " + 4.+(10))

    //If a method has only one parameter then we can call the method without using dot and parentheses
    println("Calling the method + without dot and parentheses -- 4 + 10 :- " + (4 + 10))

    /*

    Data Types :- Boolean, Char, Int, Double, String
    Boolean data type has only 2 values true and false
    Char data type can be used to represent individual characters
    Chars are stored internally as integers
    Char literals are represented using single quotes
    String data type is used to represent collection of characters
    String literals are represented using double quotes
    String can be concatenated using +
    When we apply * on strings it works as a repetition operator

    */

    println("Converting Char to Int which prints the equivalent ASCII value ('a'.toInt) :- " + 'a'.toInt) //The ASCII value of a is 97
    println("Performing operations on Char datatype :- ")
    println("Addition ('a' + 4):- " + ('a' + 4))
    println("Subtraction ('a' - 4):- " + ('a' - 4))
    println("Converting Int to Char (100.toChar) :- " + 100.toChar)
    println("Converting Int to Binary 53.toBinaryString :- " + 53.toBinaryString)
    println("Converting Int to Hexadecimal string (149.toHexString) :- " + 149.toHexString)
    println("Converting Int to Octal (149.toOctalString) :- " + 149.toOctalString)

    println("String Concatenation :- " + "Hello" + " World")
    println("String Repetition operator :- " + "Hello" * 4)

    /*
    Tuple is a combination of other data types
    We create tuples by placing the value in parentheses
    Tuple index starts with 1 and we can access the elements using _<index> notation
    */

    val tuple1 = ("Hello",45,2.14,true)
    println("First element of the tuple :- " + tuple1 + " is " + tuple1._1)
    println("Second element of the tuple :- " + tuple1 + " is " + tuple1._2)

    //creating two valued tuple in a different way
    val tuple2 = "Hello" -> 90
    println("Two valued tuple in a different way :- " + tuple2)

    val tuple3 = "Hello" -> 90 -> 4.6 -> true
    println("Complicated two valued tuple :- " + tuple3)
    println("Accessing element 90 from the tuple " + tuple3 + " using tuple3._1._1._2 and the result is " + tuple3._1._1._2)

    //Details of Int
    println("Maximum value Int data type can hold :- " + Int.MaxValue)
    println("Minimum value Int data type can hold :- " + Int.MinValue)

    //The result of the below expression wil be negative
    // This is because once the result exceeds the maximum value an Int can hold it goes in the circle to the minimum value
    println("2000000000 + 2000000000 = " + (2000000000 + 2000000000))

    //Other Integer types :- Byte, Short, Long, Char
    println("Byte Maximum Value :- " + Byte.MaxValue)
    println("Byte Minimum Value :- " + Byte.MinValue)
    println("Short Maximum Value :- " + Short.MaxValue)
    println("Short Minimum Value :- " + Short.MinValue)
    println("Long Maximum Value :- " + Long.MaxValue)
    println("Long Minimum Value :- " + Long.MinValue)
    println("Char Minimum value :- " + Char.MinValue.toInt)
    println("Char Maximum value :- " + Char.MaxValue.toInt)

    //Convert a literal to Long by placing L at the end
    //The below expression gives the correct result this is because long has 64 bits and can hold large values
    println("2000000000L + 2000000000L = " + (2000000000L + 2000000000L))

    //The below expression won't yield the output as 0 because doubles are represented differently inside computer
    //Never compare two double values to determine the result. We might not get expected results
    println("Arithmetic on floating point numbers :- " + (1.0 - 0.9 -0.1))
    println("We can convert a literal to float by adding f at the end :- " + 1.0f)

    //Package Math has many useful functions
    println("Math.PI :- " + Math.PI)
    println("Math.E :- " + Math.E)
    println("Math.sqrt :- " + Math.sqrt(64))
    println("Math.random :- " + Math.random)

    //Variable names should not start with a digit
    //As a rule of thumb always try to use vals in your code use var if you can't figure out the solution with var
    //All the data types we have discussed so far are immutable meaning they can't be changed once created
    //We can mutate the var but we can't make them point to a different object
    var a = "Hello"
    //a = 10 -- This expression is incorrect because we can't point a to a different type of object we can only point to String
    a = "world"
    println("Mutated variable of a is :- " + a)

    //String Interpolation
    val (name,age,height) = ("John",25,6.1)
    println("My name is " + name + ", My age is " + age + " and My height is " + height) //some times it is very difficult to concatenate strings like this
    println(s"My name is $name, My age is $age and My height is $height")
    //If we want to perform any operation we need to enclose the expression in flower brackets
    println(s"My name is $name, My age is ${age+5} and My height is $height")
  }
}
