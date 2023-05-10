import scala.io.StdIn.readInt

object Chapter6_tryCatch {
  def main(args : Array[String]) : Unit = {
    val a : Int = try {
      print("Enter the first integer :- ")
      readInt
    } catch {
      case e : NumberFormatException =>
        println("You didn't enter an integer..hence assigning the value -1 to the variable")
        -1
    }
    println("The value of a is " + a)
    safeRead()
  }

  private def safeRead() : Unit = {
    try {
      print("Enter the second integer :- ")
      val i = readInt
      println(s"You entered an integer and the value of it is $i")
    } catch {
      case e : NumberFormatException =>
        println("You didn't enter an integer..please try again")
        safeRead()
    }
  }
}
