package FunctionalProgramming.ScalaConcepts

object Chapter2_StringMethods {
  def main(args : Array[String]) : Unit = {
    val name = "Dharani Kumar Gopavaram"
    try {
      println(s"The original string is $name")
      println(s"Length of the original string $name is :- ${name.length}")
      //String index starts with 0 and we can access the elements by placing the index in parentheses
      println("We are accessing the elements using index")
      println(s"First character of the string $name is ${name(0)}")
      println(s"Second character of the string $name is ${name(1)}")
      //println(s"Accessing the index which doesn't exist ${name(30)}") //this will cause IndexOutOfBoundsException

      /*
        indexOf method :- returns the index of the string we passed
        If the specified string doesn't exist we get -1 as the result
        indexOf method is overloaded. There are two versions of it
        indexOf("String")
        indexOf("String",index) -- In this version it will start searching for the String from the index we specify
        There is a method called lastIndexOf which will search for the string we specify from end to start
      */
      println(s"""Index of "n" in the string $name is ${name.indexOf("n")} """)
      println(s"""Index of "x" in the string $name is ${name.indexOf("x")} """)

      //since n doesn't exist in the original string after index 5 the below expression gives -1 as the result
      println(s"""Index of "n" in the string $name starting from index 6 is ${name.indexOf("n",6)} """)
      println(s"""Last index of "a" in the string $name is ${name.lastIndexOf("a")} """)
      println(s"""Last index of "a" in the string $name starting from index 15 in the backward direction is ${name.lastIndexOf("a",15)} """)

      /*
        Substring method is used to extract portions of the original string
        This method is overloaded and has two versions of it
        substring(index) -- returns all the characters starting from index
        substring(fromIndex,toIndex) -- returns all the characters starting from fromIndex to toIndex(not inclusive)
      */

      println(s"substring(8) method on the string $name wil return :- ${name.substring(8)}")
      println(s"substring(8,13) method on the string $name wil return :- ${name.substring(8,13)}")

      //trim method can be used to remove the spaces from both sides of the string
      //splitAt method splits the string at the specified index and returns a tuple
      val lastSpaceIndex = name.lastIndexOf(" ")
      val (first,last) = name.splitAt(lastSpaceIndex)
      println(s"Printing the values returned by the splitAt method :- ${last.trim}, $first")
      val (first1,last1) = (name.substring(0,lastSpaceIndex),name.substring(lastSpaceIndex + 1))
      println(s"Printing the firstName and lastName using substring method :- $last1, $first1")

      println(s"Converting the original string to upper case :- ${name.toUpperCase}")
      println(s"Converting the original string to lower case :- ${name.toLowerCase}")
      //The methods we apply on Strings doesn't alter the original string because strings are immutable
      //Instead it creates a new String object with the required changes

      //Given the hours, minutes and seconds separated by colon
      //Convert the total time to seconds
      print("Enter time separated by colon b/w hours, minutes and seconds :- ")
      val time = "24:00:00"
      val firstColon = time.indexOf(":")
      val secondColon = time.lastIndexOf(":")
      val hours = time.substring(0,firstColon).toInt
      val minutes = time.substring(firstColon + 1 , secondColon).toInt
      val seconds = time.substring(secondColon + 1).toInt
      val totalSeconds = hours * 3600 + minutes * 60 + seconds
      println(s"The total time in seconds is :- $totalSeconds")

      //There is a type Unit in scala which is similar to type void in Java/C++ and it has only one value associated with it which is ()
      //Many void returning methods in Java are mapped to Unit returning methods in Scala.
      //The assignments in Scala give the Unit return type.

      val unitType : Unit = {
        println("The below code block returns unit type")
        val a = 10
      }

      println(s"unitType variable value is :- $unitType")

      //The comparison operators in scala are ==, !=, < , >, <= , >=, eq(which checks the identity of the two variables but rarely used we use == more)
      //The Boolean operators are &&, || (inclusive OR), ^ (exclusive OR), !(not)

      /*
        && (If any of the expression returns false the output is false otherwise the output is true)
        || (If any of the expression returns true the output is true otherwise the output is false. If both the conditions are true the output is true)
        ^  (If any of the expression returns true the output is true otherwise the output is false. If both the conditions are true the output is false)

        && and || are short circuited meaning if the first expression determines the result the second expression is not evaluated.
      */

      println(s"map method on strings :- ${name.map(c => c + 1)}") //since chars are treated internally we see only integer outputs here
      println(s"map method on strings :- ${name.map(c => (c + 1).toChar)}") //this will give us the correct output
      println(s"count method on strings :- ${name.count(c => "aeiou".contains(c))}") //this expression will give us the number of vowels present in the string
      println(s"split method on strings :- ${name.split(" ").toList}") //splits the string based on the separator we gave and returns an array
      println("Dharani  Kumar Gopavaram".split(" ").toList) //If there are multiple spaces it will treat extra space as a separate string to overcome this we can use regular expression
      println("Dharani  Kumar Gopavaram".split(" +").toList) //In this expression + means one or more
      println(s"""split method usage :- ${"1 2 3 4 5 6".split(" ").map(x => x.toInt).sum}""")
    } catch {
      case s : StringIndexOutOfBoundsException =>
        println("Exception occurred because you are accessing an element which doesn't exist")
        println(s"Please try the index between 0 and ${name.length}")
    }


  }
}
