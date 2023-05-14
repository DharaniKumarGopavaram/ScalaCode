package ObjectOrientedProgramming.Chapter10_Parametric_Polymorphism

class ToDValues[A] {
  private val values : Array[Option[A]] = Array.fill(24)(None)
  def get(hour : Int) = values(hour)
  def update(hour : Int, v : A) = values(hour) = Some(v)
  def clear(hour : Int) = values(hour) = None
  def combine(other : ToDValues[A], f : (Option[A],Option[A]) => Option[A]) : ToDValues[A] = {
    val finalToDValues = new ToDValues[A]
    for((v,i) <- values.lazyZip(other.values).map((v1,v2) => f(v1,v2)).zipWithIndex) {
      finalToDValues.values(i) = v
    }
    finalToDValues
  }
}

object ToDValues extends App {

  val riders1 = new ToDValues[Int]
  val riders2 = new ToDValues[Int]
  val workers1 = new ToDValues[String]
  val workers2 = new ToDValues[String]

  riders1(10) = 23
  riders1(15) = 90
  riders2(10) = 24
  riders2(9) = 32

  val finalRiders = riders1.combine(riders2,(o1,o2) => (o1,o2) match {
    case (None,None) => None
    case (Some(a),None) => Some(a)
    case (None,Some(a)) => Some(a)
    case (Some(a),Some(b)) => Some(a + b)
  })

  finalRiders.values.foreach(println)
}
