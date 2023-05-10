package Collections

object CollectionMethods {
  def main(args : Array[String]) : Unit = {
    /*
      All the below methods will work on any collections i.e. Lists, Arrays etc.,
      drop method :- drops elements from the list and returns a new list
      init method :- returns a new list without the last element
      last method :- returns the last element of the list
      head method :- returns the first element of the list
      tail method :- returns a new list without the first element
      slice method :- returns a new list with the elements b/w fromIndex and toIndex(not inclusive)
      splitAt method :- returns a tuple of new lists which are split at the index we specify
      take method :- takes elements from the list and returns a new list
      takeRight method :- same like take but works from right to left
      dropRight method :- same like drop but works from right to left
      contains method :- returns true if the value we specify exists in the collection otherwise returns false
      startsWith method :- checks whether the collection starts with the sequence of values we specify or not
      endsWith method :- checks whether the collection ends with the sequence of values we specify or not
      isEmpty :- to check whether the collection is empty or not
      nonEmpty :- to check whether the collection is nonEmpty or not
      indexOf method :- returns the first index of the element we specify
      lastIndexOf method :- returns the last index of the element we specify
      diff method :- will remove all the elements we specify from the original list duplicates are not ignored it doesn't do anything if the elements we specify doesn't exist in the collection
      distinct :- removes duplicates from the collection
      mkString :- will create a string out of the collection elements
      There is a method called patch which takes 3 arguments
      First argument -- The index from where patching should start
      Second argument -- the content which needs to be patched
      Third argument -- The number of elements you want to patch the content with
      reverse method :- reverse the contents of the collection
      The below methods will work only on collections where all the values are Int
      min, max, sum, product
      We can use toArray and toList to convert the collection to other types
      zip method :- will combine the elements of two collections it will stop as soon as any collection ends
      zipWithIndex :- returns a new list of two valued tuples with value and it's index as an element
      map function :- takes a function as an argument and applies that function to all the elements in the collection
      filter function :- takes a boolean function and returns all the elements that satisfy the condition
      filterNot function :- same like filter but returns elements that do not satisfy the condition
      count :- takes in a boolean function and returns the number of elements that satisfy the condition
      dropWhile :- drops all the elements that satisfy the condition and returns all the elements after that once the condition becomes false
      exists :- returns true if there is any element in the collection that satisfies the condition otherwise returns false
      flatMap :- requires a function that returns a collection but instead of generating multiple collections it will generate single collection
      forall :- checks whether the boolean function is true for all the elements in the collection or not
      foreach :- accepts a function that returns Unit
      indexWhere :- returns the first index of the element which satisfies the condition otherwise returns -1
      lastIndexWhere :- same like indexWhere but searches from last
      partition :- returns a tuple of collection where the first collection contains the elements that satisfy the condition and the second collection contains the elements that do not satisfy the condition
      takeWhile :- returns all the elements that satisfy the condition stops returning the elements once the condition becomes false
      reduceLeft :- takes a function with two arguments and perform the operation we specify inside the function
      fold :- same like reduce but it will overcome some of the limitations of reduce
      combinations :- returns all the combinations of the number of elements we specify the order doesn't matter here
      grouped :- groups collection elements into the number we specify and returns an Iterator
      inits :- will remove the last element from the collection on each iteration. The last collection returned is an empty collection
      tails :- same like inits but will remove the first element on each iteration
      permutations :- same like combinations but it will consider the order of the elements as well
      sliding :- sliding is same like grouped but the elements will be overlapped
    */

    val sampleList = List(7,5,3,9,6,1,2,1)
    println(s"Sample List :- $sampleList")
    println(s"drop method drop(2):- ${sampleList.drop(2)}")
    println(s"drop method drop(3):- ${sampleList.drop(3)}")
    println(s"init method :- ${sampleList.init}")
    println(s"last method :- ${sampleList.last}")
    println(s"head method :- ${sampleList.head}")
    println(s"tail method :- ${sampleList.tail}")
    println(s"slice method slice(3,7) :- ${sampleList.slice(3,7)} ")
    println(s"splitAt method splitAt(4) :- ${sampleList.splitAt(4)}")
    println(s"take method take(3) :- ${sampleList.take(3)}")
    println(s"takeRight method takeRight(3) :- ${sampleList.takeRight(3)}")
    println(s"dropRight method dropRight(3) :- ${sampleList.dropRight(3)}")
    println(s"contains method -- contains(6) :- ${sampleList.contains(6)}")
    println(s"contains method -- contains(99) :- ${sampleList.contains(99)}")
    println(s"startsWith method -- startsWith(Seq(7,5)) :- ${sampleList.startsWith(Seq(7,5))}")
    println(s"startsWith method -- startsWith(Seq(7,5,9)) :- ${sampleList.startsWith(Seq(7,5,9))}")
    println(s"endWith method -- endsWith(Seq(1,2,1)) :- ${sampleList.endsWith(Seq(1,2,1))}")
    println(s"endsWith method -- endsWith(Seq(1,2,3)) :- ${sampleList.endsWith(Seq(1,2,3))}")
    println(s"isEmpty method :- ${sampleList.isEmpty}")
    println(s"nonEmpty method :- ${sampleList.nonEmpty}")
    println(s"indexOf method :- ${sampleList.indexOf(1)}")
    println(s"indexOf method :- ${sampleList.indexOf(1,6)}")
    println(s"lastIndexOf method :- ${sampleList.lastIndexOf(1)}")
    println(s"diff method sampleList.diff(Array(1,2,3,4,5,99,100)) :- ${sampleList.diff(Array(1,2,3,4,5,99,100))}")
    println(s"distinct method :- ${sampleList.distinct}")
    println(s"mkString first example sampleList.mkString :- ${sampleList.mkString} ")
    println(s"""mkString second example sampleList.mkString(",") :- ${sampleList.mkString(",")} """)
    println(s"""mkString third example sampleList.mkString("(",",",")") :- ${sampleList.mkString("(",",",")")} """)
    println(s"patch method example 1 :- ${sampleList.patch(2,Nil,4)}") //Replacing 4 elements starting with index2 with nothing
    println(s"patch method example 2 :- ${sampleList.patch(2,Array(66,77,88,99,100),2)}") //The patching content can have more elements than the elements we are replacing with
    println(s"reverse method :- ${sampleList.reverse}")
    println(s"min method :- ${sampleList.min}")
    println(s"max method :- ${sampleList.max}")
    println(s"sum method :- ${sampleList.sum}")
    println(s"product method :- ${sampleList.product}")
    val numbersList = List.tabulate(10)(i => i + 1)
    val romanArray = Array("I","II","III","IV","V")
    println(s"numbersList :- $numbersList")
    println(s"romanArray :- ${romanArray.mkString(",")}")
    println(s"zip method numbersList.zip(romanArray) :- ${numbersList.zip(romanArray)}")
    println(s"zip method romanArray.zip(numbersList)   :- ${romanArray.zip(numbersList).mkString(",")}") //The type we get when we call zip method is based on the collection type we are calling
    println(s"zipWithIndex method :- ${sampleList.zipWithIndex}")
    println(s"map function example 1 :- ${sampleList.map(x => x * 2)}")
    println(s"map function example 1 :- ${sampleList.map(_ * 2)}") //We can use underscore notation as well
    println(s"map function example 3 :- ${sampleList.map(x => x * x)}")
    println(s"filter function example 1 :- ${sampleList.filter(x => x % 2 == 0)}")
    println(s"filter function example 2 :- ${sampleList.filter(x => x % 2 == 1)}")
    println(s"filterNot function :- ${sampleList.filterNot(x => x % 2 == 0)}")
    println(s"map and filter combination :- ${sampleList.filter(x => x % 2 == 0).map(_ * 2)}")
    println(s"count function :- ${sampleList.count(x => x >= 7)}")
    println(s"dropWhile function example 1:- ${sampleList.dropWhile(x => x < 9)}") //the elements 7,5,3 are dropped
    println(s"dropWhile function example 2 :- ${sampleList.dropWhile(_ > 1)}")
    println(s"exists function example 1:- ${sampleList.exists(x => x % 12 == 0)}")
    println(s"exists function example 2:- ${sampleList.exists(x => x % 3 == 0)}")
    println(s"map function that returns a collection for each element :- ${sampleList.map(x => List.fill(x)(x))}")
    println(s"flatMap function :- ${sampleList.flatMap(x => List.fill(x)(x))}")
    println(s"forall function example 1:- ${sampleList.forall(_ < 10)}")
    println(s"forall function example 2:- ${sampleList.forall(_ < 8)}")
    println(s"foreach function :- ")
    sampleList.foreach(println)
    println(s"indexWhere function example 1 :- ${sampleList.indexWhere(_ > 8)}")
    println(s"indexWhere function example 2 :- ${sampleList.indexWhere(_ > 18)}")
    println(s"lastIndexWhere :- ${sampleList.lastIndexWhere(x => x >= 1)}")
    println(s"partition function :- ${sampleList.partition(x => x % 2 == 0)}")
    println(s"takeWhile function :- ${sampleList.takeWhile(x => x < 9)}") //the elements 7,5,3 are returned
    println(s"reduce function :- ${sampleList.reduce((x,y) => {println(s"$x + $y");x + y})}")
    println(s"reduce function :- ${sampleList.reduce(_ + _)}") //we can use underscore notation as well
    //sampleList.reduce((x,y) => s"$x + $y") -- Here we are returning string where as reduce function expects us to return Int
    //The above expression is incorrect since reduce excepts the return type of function should be the same type as the collection on which we are calling it
    println(s"reduceLeft function :- ${sampleList.reduceLeft((x,y) => {println(s"$x - $y");x - y})}")
    println(s"reduceRight function :- ${sampleList.reduceRight((x,y) => {println(s"$x - $y");x - y})}")
    println(s"foldLeft function example1 :- ${sampleList.foldLeft(2)((x,y) => x + y)}")
    println(s"foldLeft function example2 :- ${sampleList.foldLeft("")((x,y) => x + y)}")
    println(s"foldLeft function example3 :- ${sampleList.foldLeft("Hello")((x,y) => {println(s"$x + $y");x + y})}")
    println(s"foldRight function example3 :- ${sampleList.foldRight("Hello")((x,y) => {println(s"$x + $y");x + y})}")
    //The below methods returns an iterator which will be gone once we consume the elements
    //Iterators have methods called next which will return the next element
    //Iterators also have a method called hasNext which will tell us whether the iterator has an element or not
    //We can convert the iterator to other collection types using methods like toList, toArray etc., but be careful while you do it since iterator can have many elements
    println(s"combinations method :- ")
    sampleList.combinations(3).foreach(a => println(a.mkString(",")))
    println("grouped method :- ")
    List.tabulate(15)(i => i + 1).grouped(4).foreach(a => println(a.mkString(",")))
    println("inits method :-")
    sampleList.inits.foreach(a => println(a.mkString(",")))
    println("tails method :- ")
    sampleList.tails.foreach(a => println(a.mkString(",")))
    println("permutations method :- ")
    List.tabulate(3)(i => i + 1).permutations.foreach(a => println(a.mkString(",")))
    println("sliding method :- ")
    sampleList.sliding(4).foreach(a => println(a.mkString(",")))
  }

}
