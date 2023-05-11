package ObjectOrientedProgramming.Chapter1_OOPBasics

//This is the immutable version of the student class here all the arguments to the class are vals
class ImmutableStudent (
    val firstName: String,
    val lastName: String,
    val tests: List[Int] = Nil,
    val assignments: List[Int] = Nil,
    val quizzes: List[Int] = Nil
  ) {

  private def validateGrade(grade : Int) : Boolean = grade >= -20 && grade <= 120
  def addTestGrade(grade : Int) : ImmutableStudent = if(validateGrade(grade)) new ImmutableStudent(
    firstName,
    lastName,
    grade :: tests,
    assignments,
    quizzes
  ) else this //this refers to the current object

  def addAssignmentGrade(grade : Int) : ImmutableStudent = if(validateGrade(grade)) new ImmutableStudent(
    firstName,
    lastName,
    tests,
    grade :: assignments,
    quizzes
  ) else this

  def addQuizGrade(grade : Int) : ImmutableStudent = if(validateGrade(grade)) new ImmutableStudent(
    firstName,
    lastName,
    tests,
    assignments,
    grade :: quizzes
  ) else this
  private def testsAverage: Double = if (tests.isEmpty) 0.0 else tests.sum.toDouble / tests.length

  private def assignmentsAverage: Double = if (assignments.isEmpty) 0.0 else assignments.sum.toDouble / assignments.length

  private def quizzesAverage: Double = if (quizzes.isEmpty) 0.0 else quizzes.sum.toDouble / quizzes.length

  def average: Double = 0.5 * testsAverage + 0.4 * assignmentsAverage + 0.1 * quizzesAverage
}