package ObjectOrientedProgramming.Chapter1_OOPBasics

object GradeBook {
  def main(args : Array[String]) : Unit = {
    val mutableStudent = new MutableStudent("John","Doe")
    printMutableStudentInfo(mutableStudent)
    val immutableStudent = new ImmutableStudent("Jane","Doe")
    printImmutableStudentInfo(immutableStudent)
  }

  private def printMutableStudentInfo(s : MutableStudent) : Unit = {
    println("Mutable Student Info")
    println(s"FirstName :- ${s.firstName}, LastName :- ${s.lastName}")
    s.addTestGrade(90)
    s.addTestGrade(98)
    s.addTestGrade(130)
    s.addAssignmentsGrade(89)
    s.addAssignmentsGrade(87)
    s.addAssignmentsGrade(86)
    s.addAssignmentsGrade(-30)
    s.addQuizGrade(90)
    s.addQuizGrade(98)
    s.addQuizGrade(190)
    println(s"tests :- ${s.getTests}")
    println(s"assignments :- ${s.getAssignments}")
    println(s"quizzes :- ${s.getQuizzes}")
    println(s"Average :- ${s.average}")
  }

  private def printImmutableStudentInfo(s : ImmutableStudent) : Unit = {
    println("Immutable student info")
    println(s"FirstName :- ${s.firstName}, LastName :- ${s.lastName}")
    val finalImmutableStudent = s.addTestGrade(90).addTestGrade(98).addAssignmentGrade(89).
      addAssignmentGrade(87).addAssignmentGrade(86).addQuizGrade(90).addQuizGrade(98).
      addQuizGrade(190).addAssignmentGrade(-30).addTestGrade(130)
    println(s"Tests :- ${finalImmutableStudent.tests}")
    println(s"Assignments :- ${finalImmutableStudent.assignments}")
    println(s"Quizzes :- ${finalImmutableStudent.quizzes}")
    println(s"Average :- ${finalImmutableStudent.average}")

  }

}
