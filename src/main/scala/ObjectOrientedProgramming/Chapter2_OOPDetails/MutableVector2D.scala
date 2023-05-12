package ObjectOrientedProgramming.Chapter2_OOPDetails

//private[this] specifies that this variable can only be accessed by the current object
class MutableVector2D(private[this] var _x : Int, private[this] var _y : Int) {
  def x : Int = _x
  def y : Int = _y

  //since we defined our class arguments as private vars we can't access them outside the class
  //to access them outside the class we are defining the below property assignment methods
  private def x_=(newX : Int) : Unit = _x = newX //these are called property assignment method
  private def y_=(newY : Int) : Unit = _y = newY

  //Since this is mutable version += makes sense than +
  def +=(mv : MutableVector2D) : MutableVector2D = {
    //_x += mv._x //Here we are accessing the class variables directly we can restrict this if we specify the class variables as private[this]
    _x += mv.x //here we are using the get methods to see the x and y value
    //_y += mv._y
    _y += mv.y
    this
  }

  def -=(mv : MutableVector2D) : MutableVector2D = {
    _x -= mv.x
    _y -= mv.y
    this //this returns the current object
  }

  def *= (c : Int) : MutableVector2D = {
    _x *= c
    _y *= c
    this
  }

  def magnitude : Double = Math.sqrt( _x * _x + _y * _y)

  def update(index : Int, newValue : Int) : Unit = {
    println("Called the updated method")
    index match {
      case 0 => _x = newValue
      case 1 => _y = newValue
      case _ => throw new IndexOutOfBoundsException("Index is out of range")
    }
  }
}

object MutableVector2D {
  def main(args : Array[String]) : Unit = {
    val v1 = MutableVector2D(1,2)
    val v2 = MutableVector2D(2,2)
    v1.x = 4 //the method x_= is called here
    v1.y = 6
    v1 += v2
    println(v1.magnitude)

    val v3 = new MutableVector2D(10,20)
    v3.update(0,1000)
    v3.update(1,2000)
    println(v3.magnitude)
  }

  //We can create objects as well from apply method
  def apply(a : Int, b : Int) = new MutableVector2D(a,b)
}
