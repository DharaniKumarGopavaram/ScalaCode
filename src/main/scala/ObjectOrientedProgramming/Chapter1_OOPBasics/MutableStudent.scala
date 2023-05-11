package ObjectOrientedProgramming.Chapter1_OOPBasics

//Just like a function a class can have arguments
//Based on our design implementation we can make our class as immutable or mutable
class MutableStudent(
    val firstName : String, //If we define the variables without val or var they are not class members and cannot be accessed outside the class
    val lastName : String, //If we define the class arguments with either val or var they can be accessed outside the class
    private var tests : List[Int] = Nil,
    private var assignments : List[Int] = Nil,
    private var quizzes : List[Int] = Nil
 ) {

  private def validateGrade(grade : Int) : Boolean = grade >= -20 && grade <= 120
  def addTestGrade(grade : Int) : Unit = if(validateGrade(grade)) {
   tests ::= grade
   println("Grade got successfully added")
  } else println("Passed grade is not correct..hence not adding it")

  def addAssignmentsGrade(grade : Int) : Unit = if (validateGrade(grade)) {
   assignments ::= grade
   println("Grade got successfully added")
  } else println("Passed grade is not correct..hence not adding it")

  def addQuizGrade(grade : Int) : Unit = if (validateGrade(grade)) {
   quizzes ::= grade
   println("Grade got successfully added")
  } else println("Passed grade is not correct..hence not adding it")

  private def testsAverage : Double = if(tests.isEmpty) 0.0 else tests.sum.toDouble / tests.length
  private def assignmentsAverage : Double = if(assignments.isEmpty) 0.0 else assignments.sum.toDouble / assignments.length
  private def quizzesAverage : Double = if(quizzes.isEmpty) 0.0 else quizzes.sum.toDouble / quizzes.length
  def average: Double = 0.5 * testsAverage + 0.4 * assignmentsAverage + 0.1 * quizzesAverage

  def getTests: List[Int] = tests //since we defined tests are private var we can't access them outside the class to access them outside the class we are creating this methods
  def getAssignments : List[Int] = assignments //For immutable version we don't need to create this methods
  def getQuizzes : List[Int] = quizzes
}
