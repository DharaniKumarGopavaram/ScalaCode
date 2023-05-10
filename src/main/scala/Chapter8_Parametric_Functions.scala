object Chapter8_Parametric_Functions {
  def main(args : Array[String]) : Unit = {
    //We can write functions in Scala that can have types as arguments
    println(s"Calling the ident function for Int type :- ${ident(10)}")
    println(s"Calling the ident function for Double type :- ${ident(34.56)}")
    println(s"Calling the ident function for String type :- ${ident("Hello")}")
    //In the above 3 statements the same ident Function is being called for Int, Double, String. That is the power of parametric functions
    println(s"Calling the makeTuple function by passing both Integers :- ${makeTuple(10,20)}")
    println(s"Calling the makeTuple function by passing a String and a double :- ${makeTuple("Hello",34.56)}")
    //In the above statements we are calling the makeTuple function for different data types
    val intList : List[Int] = threeList(10,20,30)
    println(intList)
    /*
      subtyping in scala :-
      Int, Double, Unit, Char, Boolean belong to a type called AnyVal
      Strings, List, Arrays belong to a type called AnyRef
      AnyVal and AnyRef are types of Any which is the ultimate parent super type
    */
    val anyList : List[Any] = threeList(100,"Dharani",34.5) //since we are passing Int and String which are subtypes of AnyVal and AnyRef scala gives Any as the type which holds both Int and String
    println(anyList)
    println(s"Calling the ourFold function example 1 :- ${ourFold(List(10,20,30,40),0,(x : Int ,y : Int) => x + y)}")
    println(s"Calling the ourFold function example 2 :- ${ourFold(List(10,20,30,40),"TheEnd",(x : Int,y : String) => x.toString + y)}")
    //In the above example we need to specify the types for the parameter f while calling the function this is because scala can't figure out the type dynamically
    //To overcome this problem we can define the function using currying
    println(s"Calling the ourFoldCurrying function example 1 :- ${ourFoldCurrying(List(10, 20, 30, 40), 0) (_ + _)}") //we can use underscore notation if we define the function using currying
    println(s"Calling the ourFoldCurrying function example 2 :- ${ourFoldCurrying(List(10, 20, 30, 40), "TheEnd") (_ + _)}")
  }
  private def ident[A](i : A) : A = i
  private def makeTuple[A,B](a : A,b : B) : (A,B) = (a,b)
  private def threeList[A](a1 : A, a2 : A, a3 : A) : List[A] = List(a1,a2,a3)
  private def ourFold[A,B](lst : List[A],base : B,f : (A,B) => B) : B = lst match {
    case Nil => base
    case h :: t => f(h,ourFold(t,base,f))
  }
  private def ourFoldCurrying[A, B](lst: List[A], base: B) (f: (A, B) => B): B = lst match {
    case Nil => base
    case h :: t => f(h, ourFoldCurrying(t, base)(f))
  }
}
