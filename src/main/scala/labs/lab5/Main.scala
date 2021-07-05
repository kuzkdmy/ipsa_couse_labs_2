package labs.lab5

import scala.collection.SeqView.Sorted

// Побудувати шаблонну функцію відповідно варіанту.
//Передбачити тестовий приклад для ілюстрації коректності роботи, у якому
//реалізувати усе, необхідне для демонстрації двох або трьох викликів функції.
//Перший виклик функції реалізувати для одного з вбудованих типів.
//Другий – для одного з реалізованих у попередніх роботах класів вашого
//варіанту (якщо номер варіанту попередніх робіт не співпадає з номером
//варіанту п’ятої роботи).
//Третій виклик – з використанням явного інстанціювання.
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

  println("------ invariant B demo ------")
  def printInvariantB(t: Invariant[B]): Unit = println(t.t)
  //  myPrint2(Invariant[A](a)) // not compiled, only B
  printInvariantB(Invariant[B](b))
  //  myPrint2(Invariant[C](c)) // not compiled, only B

  println("------ covariant B demo ------")
  def printCovariantB(t: Covariant[B]): Unit = println(t.t)
  //  myPrint3(Covariant[A](a)) // not compiled, only B and C
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
