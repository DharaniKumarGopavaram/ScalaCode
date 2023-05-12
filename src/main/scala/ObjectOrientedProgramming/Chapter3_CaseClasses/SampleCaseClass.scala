package ObjectOrientedProgramming.Chapter3_CaseClasses

//If you are willing to make your class immutable then try to define it as case class which has class arguments vals by default
case class SampleCaseClass(x : Int, y : Int, z : Int) {
  def +(s : SampleCaseClass) = SampleCaseClass(x + s.x, y + s.y ,z + s.z)
}

object SampleCaseClass {
  def main(args: Array[String]): Unit = {
    val s1: SampleCaseClass = SampleCaseClass(10, 20, 30) //no need to use new keyword while creating case classes
    val s2: SampleCaseClass = SampleCaseClass(10, 20, 30)
    println(s"s1.x - ${s1.x}, s1.y :- ${s1.y}, s1.z :- ${s1.z}")
    val s3: SampleCaseClass = s1 + s2
    println(s3) //case classes print nicely
    println(s1 == s2) //we can compare case classes objects easily and this returns true whereas for normal classes this returns false
  }

}