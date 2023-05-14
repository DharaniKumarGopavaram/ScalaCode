package ObjectOrientedProgramming.Chapter6_AbstractClasses

/*
  abstract classes are the classes which can have both abstract methods(without function body) and normal methods
  We can instantiate a abstract class
  If any child class inherits from the abstract class then that child class should definitely provide implementation for the methods that are abstract in parent class
  Otherwise we need to declare the child class as abstract class
*/
abstract class Shape {
  def area : Double
  def perimeter : Double
}

class Rectangle(val width : Double,val height : Double ) extends Shape {
  override def area : Double = width * height
  override def perimeter: Double = 2 * (width + height)
}

object SampleMain {
  def main(args : Array[String]) : Unit = {
    val rect = new Rectangle(10,20)
    println(s"Area of the rectangle :- ${rect.area}")
    println(s"Perimeter of the rectangle :- ${rect.perimeter}")
  }
}