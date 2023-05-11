
case class Point3D(x : Int, y : Int, z : Int) //creating case classes
case class MutablePoint3D(var x : Int, var y : Int, var z : Int)
case class Student(name : String, tests : List[Int],assignments : List[Int], quizzes : List[Int])
object Chapter18_CaseClasses {
  def main(args : Array[String]) : Unit = {
    val point1 = Point3D(10,20,30) //Instantiating a case class we don't need new keyword
    val point2 = Point3D(30,40,50)
    val point3 = point2.copy(100 + point2.x) //using copy method we can create new case classes like this. We are using named arguments here
    val point4 = point2.copy(y = 100 + point2.x)
    println(point1.x) //Accessing the elements of a case class
    println(point1.z)
    println(s"point1 :- ${point1}")
    println(s"point2 :- ${point2}")
    println(s"point3 :- ${point3}")
    println(s"point4 :- ${point4}")
    //by default case class variables are vals we can't reassign them

    val sampleStudent = Student("John",Nil,Nil,Nil)
    val sampleTestsStudent = sampleStudent.copy(tests = 10 :: 20 :: 30 :: 40 :: sampleStudent.tests)
    println(s"sampleTestsStudent :- $sampleTestsStudent")
    val sampleAssignmentStudent = sampleTestsStudent.copy(assignments = 10 :: 20 :: 30 :: 40 :: sampleTestsStudent.assignments)
    println(s"sampleAssignmentStudent :- $sampleAssignmentStudent")

    val student1 = Student("John",List(10,20,30,40),List(50,60,70),List(90,100,110,120,130))
    println(student1.name)
    println(student1.tests(3))

    println(s"calling the pointDistance function :- ${pointDistance(point1,point2)}")
    println(s"calling the classAverage function :- ${classAverage(student1)}")

    //Named arguments helps us to pass arguments to a function in the order we require them
    println(s"calling the evalPoly function using named arguments :- ${evalPoly(x = 2,a = 3,c = 5,b = 2)}")
    println(s"calling the evalPoly function using combination of positional arguments and named arguments :- ${evalPoly(3,2,x = 2, c = 5)}")
    println(s"calling the evalPolyDefault function :- ${evalPolyDefault(x = 4)}")
    println(s"calling the evalPolyDefault function :- ${evalPolyDefault(x = 4,b = 1)}")

    //pattern matching on case classes
    val points = Array.fill(30)(Point3D(util.Random.nextInt(10),util.Random.nextInt(10),util.Random.nextInt(10)))
    println(s"points :- ${points.mkString(",")}")
    val yieldResult1 = for(Point3D(x,y,z) <- points) yield x * x + y * y + z * z
    val yieldResult2 = for(Point3D(1,y,z) <- points) yield 1 + y * y + z * z
    println(s"yieldResult1 :- ${yieldResult1.mkString(",")}")
    println(s"yieldResult2 :- ${yieldResult2.mkString(",")}")

    //Mutable case classes
    val mutablePoint = MutablePoint3D(1,2,3)
    println(s"mutablePoint before changing :- $mutablePoint")
    mutablePoint.y = 99
    println(s"mutablePoint after changing :- $mutablePoint")
  }

  private def pointDistance(p1 : Point3D,p2 : Point3D) : Double = {
    val dx = p1.x - p2.x
    val dy = p1.y - p2.y
    val dz = p1.z - p2.z
    Math.sqrt(dx * dx + dy * dy + dz * dz)
  }

  private def classAverage(s : Student) : Double = {
    0.4 * s.tests.sum / s.tests.length + 0.5 * s.assignments.sum / s.assignments.length + 0.1 * s.quizzes.sum / s.quizzes.length
  }

  private def evalPoly(a : Int, b : Int, c : Int, x : Int) : Int = {
    a * x * x + b * x + c
  }

  //We can have default values to the arguments of a function like this
  private def evalPolyDefault(a : Int = 0,b : Int = 0, c : Int = 0, x : Int) : Int = {
    a * x * x + b * x + c
  }
}
