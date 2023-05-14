package ObjectOrientedProgramming.Chapter4_InclusionPolymorphism
class Shape {
  def area : Double = 0.0
  def perimeter : Double = 0.0
}

/*
  Inheritance :-
  We can inherit classes in scala using extends keyword
  Inheritance provides two things
  1. Code re-usability -- Since we have access to the parent class methods
  2. Subtyping -- We can pass child objects to the methods defined to accept parent type

*/

class Rectangle(val width : Double,val height : Double) extends Shape {
  override def area: Double = width * height // we are overriding the parent class methods hence we are using override method
  override def perimeter: Double = 2 * (width + height)
}

class Circle(val radius : Double) extends Shape {
  override def area: Double = Math.PI * radius * radius
  override def perimeter: Double = 2 * Math.PI * radius

}

class Square(val length : Double) extends Rectangle(length,length)
//since square is special type of rectangle we can use the same rectangle class to calculate perimeter and ared

object Shape {
  def main(args : Array[String]) : Unit = {
    val rect = new Rectangle(3,4)
    println("Calling the printShapeData function for rectangle")
    printShapeData(rect)
    val circle = new Circle(10)
    println("Calling the printShapeData function for circle")
    printShapeData(circle)
    val square = new Square(10)
    println("Calling the printShapeData function for square")
    printShapeData(square)
  }

  //even though we defined printShapeData which accepts Shape object as we can pass Rectangle and Circle objects since they are subtype of the parent type Shape
  //This is the power of inclusion polymorphism
  private def printShapeData(s : Shape) : Unit = {
    println(s"Area :- ${s.area}")
    println(s"Perimeter :- ${s.perimeter}")
  }
}