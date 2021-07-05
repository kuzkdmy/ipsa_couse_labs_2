package labs.lab5

object Main extends App {
  class A {
    override def toString: String = this.getClass.getSimpleName
    def methodA: String = "method in A"
  }
  class B extends A {
    def methodB: String = "method in B"
  }
  class C extends B {
    def methodC: String = "method in C"
  }

  val a = new A()
  val b = new B()
  val c = new C()

  println("------  Parameterized generic method demo ------")
  def printGeneric[T](t: T): Unit = println(t)
  printGeneric(1)
  printGeneric("string type output")
  printGeneric(a)
  printGeneric(b)
  printGeneric(c)

  println("------ Parameterized classes demo ------")
  case class Invariant[T](t: T)
  case class Covariant[+T](t: T)
  case class Contravariant[-T]() { def printAsConsume: T => Unit = println(_) }

  // covariant explain by compiler
  // yes, 'list' of B(C) is also a 'list' of A
  val _: Covariant[A] = new Covariant[A](c)
  val _: Covariant[A] = new Covariant[B](c)
  val _: Covariant[A] = new Covariant[C](c)

  // invariant explain by compiler
  // not, 'list' of B(C) is not also a 'list' of A
  val _: Invariant[A] = new Invariant[A](c)
  val _: Invariant[B] = new Invariant[B](b)
//  val _ : Invariant[A] = new Invariant[B](c) // found   : labs.lab5.Main.Invariant[labs.lab5.Main.A], required: labs.lab5.Main.Invariant[labs.lab5.Main.B]
//  val _ : Invariant[A] = new Invariant[C](c) // found   : labs.lab5.Main.Invariant[labs.lab5.Main.A], required: labs.lab5.Main.Invariant[labs.lab5.Main.C]

  // contravariant explain by compiler
  // no, 'list' of B(C) is not also a 'list' of A
  // this is backwards, 'list' of A(B) is also a 'list' of C
  val _: Contravariant[A] = new Contravariant[A]()
  val _: Contravariant[A] = new Contravariant[B]()
  val _: Contravariant[A] = new Contravariant[C]()
  val _: Contravariant[C] = new Contravariant[A]()
  val _: Contravariant[C] = new Contravariant[B]()
  val _: Contravariant[C] = new Contravariant[C]()

  // how this Contravariant works and why it exists
  // клініка яка вміє лікувати Animal (A)
  class Vet[-T <: A] {
    def heal(t: T): Boolean = true
  }
  val clinic: Vet[B] = new Vet[A]
//  clinic.heal(a)
  clinic.heal(b)
  clinic.heal(c)

  // small compiler example for covariant and lower type bounds
  abstract class MyList[+T] {
    def head: T
    def tail: MyList[T]
//    def add(t: T): MyList[T] // covariant type T occurs in contravariant position in type T of value t
    def add[T1 >: T](t: T1): MyList[T]
  }

  println("------ invariant B demo ------")
  def printInvariantB(t: Invariant[B]): Unit = println(t.t)
//  printInvariantB(Invariant[A](a)) // not compiled, only B
  printInvariantB(Invariant[B](b))
//  printInvariantB(Invariant[C](c)) // not compiled, only B

  println("------ covariant B demo ------")
  def printCovariantB(t: Covariant[B]): Unit = println(t.t)
//  printCovariantB(Covariant[A](a)) // not compiled, only B and C
  printCovariantB(Covariant[B](b))
  printCovariantB(Covariant[C](c))

  println("------ contravariant A demo ------")
  Contravariant[A]().printAsConsume(a)
  Contravariant[A]().printAsConsume(b)
  Contravariant[A]().printAsConsume(c)

  println("------ contravariant B demo ------")
  //  println(Contravariant[B]().consume(a)) // not compiled, only B and C
  Contravariant[B]().printAsConsume(b)
  Contravariant[B]().printAsConsume(c)

  println("------ contravariant C demo ------")
  //  println(Contravariant[C]().consume(a)) // not compiled, only C
  //  println(Contravariant[C]().consume(b)) // not compiled, only C
  Contravariant[C]().printAsConsume(c)

  println("------  Upper bounds demo ------")
  def printUpperBoundB[T <: B](t: T): Unit = println(t)
  //  myPrint2(1) // not compiled, only B and C
  //  myPrint2("string type output") // not compiled, only B and C
  //  myPrint2(a) // not compiled, only B and C
  printUpperBoundB(b)
  printUpperBoundB(c)

  println("------  Lower bounds demo(note: type T refer to a supertype of type B) ------")
  def printLowerBoundB[T >: B](t: T): Unit = println(t)
  printLowerBoundB(1)
  //  printLowerBoundB[B](1) // not compiled, required B found Int
  printLowerBoundB("string type output")
  //  printLowerBoundB[B]("string type output") // not compiled, required B found String
  printLowerBoundB(a)
  //  printLowerBoundB[B](a) // not compiled, required B found A
  printLowerBoundB(b)
  printLowerBoundB[B](b)
  printLowerBoundB(c)
  printLowerBoundB[B](c)

}
