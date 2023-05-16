package FunctionalProgramming.Collections

//This is very very important program practice it many many times
//Given a name tell the maximum year in which the name got repeated
object UsingMaps {
  def main(args : Array[String]) : Unit = {
    case class TotalNameDataInfo(gender : Char,year : Int, nameGiven : String, nameCount : Int)
    val overallStateInfo = for {
      stateFile <- new java.io.File("/Users/dharani-kumar/Desktop/Data").list
      if stateFile.endsWith("TXT")
    } yield {
      val source = io.Source.fromFile(s"/Users/dharani-kumar/Desktop/Data/$stateFile")
      val stateInfo = source.getLines().filter(_.nonEmpty).map { line =>
        val splits = line.split(",")
        TotalNameDataInfo(splits(1)(0), splits(2).toInt, splits(3), splits(4).toInt)
      }.toArray
      source.close()
      (stateFile.take(2),stateInfo)
    }
    val nameToSearch = "Mark"
    for((state,data) <- overallStateInfo) {
      println(s"The ${state} is having $nameToSearch highest number of times in the year :- ${data.groupBy(_.nameGiven)(nameToSearch).maxBy(_.nameCount)}")
    }
    //Given a name find in which state and year was it used the most

    println(overallStateInfo.flatMap(x => x._2).groupBy(_.nameGiven)(nameToSearch).maxBy(_.nameCount))
  }
}
