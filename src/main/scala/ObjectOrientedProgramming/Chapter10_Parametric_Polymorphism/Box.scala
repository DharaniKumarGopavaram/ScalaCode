package ObjectOrientedProgramming.Chapter10_Parametric_Polymorphism

//The below example demonstrates parametric polymorphism on classes

class Box[T](private var value : T)  {
  def getValue : T = value
  def setValue(newValue : T) : Unit = {
    value = newValue
  }
}

object MainBox {
  def main(args : Array[String]) : Unit = {
    val intBox = new Box(42) //we can create class instances with different types
    val stringBox = new Box("Dharani")
    println(intBox.getValue)
    intBox.setValue(100)
    println(intBox.getValue)
    println(stringBox.getValue)
  }
}
