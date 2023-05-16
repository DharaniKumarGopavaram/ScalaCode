package FunctionalProgramming.Collections

//This is an important program practice it many many times

import java.io.File

object UsingSets {
  def main(args : Array[String]) : Unit = {
    val year = 2015
    val nationalData = {
      val source = io.Source.fromFile(s"/Users/dharani-kumar/Desktop/Data/yob${year}.txt")
      val lines = source.getLines().filter(_.nonEmpty).map(x => x.split(",")(0)).toSet
      source.close()
      lines
    }
    println(s"The total number of names in the year $year is ${nationalData.size}")

    val info = for {
      stateFile <- new File("/Users/dharani-kumar/Desktop/Data").list()
      if stateFile.endsWith("TXT")
    } yield {
        val source = io.Source.fromFile(s"/Users/dharani-kumar/Desktop/Data/$stateFile")
        val stateNames = source.getLines().filter(_.nonEmpty).map(x => x.split(","))
          .filter(x => x(2).toInt == year).map(x => x(3)).toArray
        source.close()
        (stateFile.take(2),stateNames)
    }
    val start = System.nanoTime()
    for((state,names) <- info) {
      println(s"The $state contains ${names.count(n => nationalData.contains(n))} names")
    }
    println(s"The last for loop took ${(System.nanoTime() - start)/ 1e9}")
    //when we convert national data to toList it takes around 3.7 seconds
    //but when we convert toSet it takes around 0.017 seconds that is the reason when we need to check if the element exists or not we should always use sets
  }
}
