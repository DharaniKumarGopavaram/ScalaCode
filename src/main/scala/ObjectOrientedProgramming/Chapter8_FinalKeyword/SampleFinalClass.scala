package ObjectOrientedProgramming.Chapter8_FinalKeyword

final class SampleFinalClass(val a : Int) {
  def printAValue() : Unit = {
    println(a)
  }
}

//Once we define a class as final no other class can inherit it
//We can only instantiate the class and access its methods

object SampleMain {
  def main(args : Array[String]) : Unit = {
    val f = new SampleFinalClass(100)
    f.printAValue()
  }
}