package ObjectOrientedProgramming.Chapter9_Enumerations

/*
Enumerations, also known as enums, are a powerful feature in Scala that provide a way to define a set of named values as a distinct type.
Enums can be useful in several scenarios:
  1. Representing a fixed set of values: Enums are often used to represent a predefined set of values that a variable can take.
     This helps in enforcing type safety and prevents the use of invalid or unexpected values.
     For example, if you have an application that deals with days of the week, you can define an enum to represent the days:
*/
object DayOfWeek extends Enumeration {
  val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
}

object EnumMain {
  def main(args : Array[String]) : Unit = {
    val today = DayOfWeek.Monday

    today match {
      case DayOfWeek.Monday | DayOfWeek.Tuesday | DayOfWeek.Wednesday | DayOfWeek.Thursday | DayOfWeek.Friday =>
        println("It's a weekday")
      case DayOfWeek.Saturday | DayOfWeek.Sunday =>
        println("It's a weekend")
    }

    DayOfWeek.values.foreach { day =>
      println(s"Name: ${day.toString}, Ordinal : ${day.id}")
    }

    val dayByName = DayOfWeek.values.find(_.toString == "Wednesday")
    val dayByOrdinal= DayOfWeek.values.find(_.id == 3)
    println(s"dayByName :- $dayByName")
    println(s"dayByOrdinal :- $dayByOrdinal")

  }
}
