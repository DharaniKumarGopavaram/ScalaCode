package ObjectOrientedProgramming.Chapter10_Parametric_Polymorphism

//Complex example which shows the parametric polymorphism on methods and classes
class ToDValues[A] private(private val values : Array[Option[A]]) { //If we give private before the class arguments it means we can instantiate the class only through the apply method
  def get(hour : Int) : Option[A] = values(hour)
  def update(hour : Int, v : A) : Unit = values(hour) = Some(v)
  def clear(hour : Int) : Unit = values(hour) = None
  def combine[B,C](o : ToDValues[B])(f : (Option[A],Option[B]) => Option[C]) : ToDValues[C] = {
    val finalToDValues = ToDValues[C]()
    for((v,i) <- values.lazyZip(o.values).map((v1,v2) => f(v1,v2)).zipWithIndex) {
      finalToDValues.values(i) = v
    }
    finalToDValues
  }
}

object ToDValues {
  def main(args : Array[String]) : Unit = {

    val riders = ToDValues[Int]()
    val worker = ToDValues[String]("Dharani","Kavya","John","Jane","Doe")

    riders(1) = 10
    riders(3) = 24
    riders(10) = 34
    riders(15) = 98
    worker(14) = "Bye"
    worker(10) = "Hello"

    riders.combine(worker)((o1,o2) => (o1,o2) match {
      case (None,None) => None
      case (Some(a),None) => Some(a)
      case (None,Some(b)) => Some(b)
      case (Some(a),Some(b)) => Some(a + b)
    }).values.foreach(println)

  }

  def apply[A]() : ToDValues[A] = new ToDValues[A](Array.fill(24)(None))
  def apply[A](a : A*) : ToDValues[A] = {
    val opts = a.map(Option(_)).toArray
    new ToDValues[A](if(opts.length < 24) opts.padTo(24,None) else if(opts.length > 24) opts.take(24) else opts)
  }
}
