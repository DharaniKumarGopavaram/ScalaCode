package ObjectOrientedProgramming.Chapter5_SuperKeyword

class ParentClass {
  def printMessage() : Unit = {
    println("Hello from parent class")
  }
}

class ChildClass extends ParentClass {
  override def printMessage(): Unit = {
    println("Hello from child class")
    println("Calling the parent class method")
    super.printMessage() //we can call the parent class method using super keyword like this
    println("Parent class method called")
    println("Continuing with child class code")
  }
}

object SuperKeyWordCheck {
  def main(args : Array[String]) : Unit ={
    val c = new ChildClass
    c.printMessage()
  }
}
