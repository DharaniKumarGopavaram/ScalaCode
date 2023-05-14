package ObjectOrientedProgramming.Chapter10_Parametric_Polymorphism

object ParametricSorts {
  private def bubbleSort[A](a : Array[A])(lt : (A,A) => Boolean) :  Unit = {
    for {
      i <- 0 until a.length - 1
      j <- 0 until a.length - i - 1
    }  {
      if(lt(a(j + 1),a(j))) {
        val tmp = a(j)
        a(j) = a(j + 1)
        a(j + 1) = tmp
      }
    }
  }

  def main(args : Array[String]) : Unit = {
    val a = Array(10,5,2,1,4,2,3,9,11)
    println(a.mkString(","))
    bubbleSort[Int](a)(_ >_)
    println(a.mkString(","))

    val b = Array(10.2,5.4,2.0,1.0,4.1,2.6,3.6,9.2,11.1)
    println(b.mkString(","))
    bubbleSort[Double](b)(_ >_)
    println(b.mkString(","))

    val c = Array("Dharani","Kavya","Hello","Jane","Bye")
    println(c.mkString(","))
    bubbleSort[String](c)(_ < _)
    println(c.mkString(","))
  }
}
