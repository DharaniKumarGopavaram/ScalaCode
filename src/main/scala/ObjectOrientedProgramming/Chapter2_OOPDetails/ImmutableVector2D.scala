package ObjectOrientedProgramming.Chapter2_OOPDetails

class ImmutableVector2D(val x : Int, val y : Int) {
  //since there are no operators in scala we can name the methods using regular operators like +, -, *, / etc.,
  def + (v : ImmutableVector2D) = ImmutableVector2D(x + v.x,y + v.y)
  def - (v : ImmutableVector2D) = ImmutableVector2D(x - v.x,y - v.y)
  def * (c : Int) = new ImmutableVector2D(x * c, y * c)

  def unary_-(): ImmutableVector2D = { //If we define a method starting with unary then we can use it as a unary operator
    println("called the unary_- method")
    ImmutableVector2D(-x, -y)
  }
  def magnitude : Double = Math.sqrt(x * x + y * y)

  //The apply method usually turns a object into a function
  def apply(index : Int) : Int = {
    println("called the apply method")
    index match {
      case 0 => x
      case 1 => y
      case _ => throw new IndexOutOfBoundsException("Exceeding the index for ImmutableVector2D class")
    }
  }
}

//When we define a object with the same name as the class name it is called companion object
//Class and companion object can access each other private members
object ImmutableVector2D {
  def main(args : Array[String]) : Unit = {

    val v1 = ImmutableVector2D(1,2)
    val v2 = ImmutableVector2D(5,6)
    val v3 = v1 + v2 //we can call the + method using operator notation
    val v4 = -v2 //this will call the unary_- method
    println(s"v4.x :- ${v4.x}, v4.y :- ${v4.y}")
    println(v3.magnitude)

    //When we create a list object using List(10,20,30) we are actually calling the apply method
    println(List(10,20,30))
    println(List.apply(100,200,300))


    val v5 = ImmutableVector2D(10,20)
    println(s"accessing the elements using apply method :- ${v5(0)}")
    println(s"accessing the elements using apply method :- ${v5(1)}")

    val v6 = ImmutableVector2D(1000,2000)
    val v7 = ImmutableVector2D(1000,2000)
    println(v6 == v7) //for normal classes this will always return false since it creates a new object every time but for case classes this returns true
    println(v6) //This doesn't print nicely but case classes return the output nicely
    //We don't need to use new keyword to create objects of case classes 

  }

  def apply(a : Int, b : Int) = new ImmutableVector2D(a,b)
}