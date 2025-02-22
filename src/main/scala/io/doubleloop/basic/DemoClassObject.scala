package io.doubleloop.basic

object DemoClass {
  def run(): Unit = {
    // Classes
    val greeter = new Greeter("Hello", ",", "!")
    println(greeter.greet("World"))

    // classes are compared by reference, like in Java
    val anotherGreeter = new Greeter("Hello", ",", "!")
    println(greeter == anotherGreeter)

    // getters and setters
    greeter.suffix = "?"
    println(greeter.prefix)
    // separator is not exposed
    // println(greeter.separator)
    println(greeter.suffix)
    println(greeter.greet("World"))

    // Objects
    println(Greeters.assertive("Hello", ",").greet("World"))
    println(Greeters.doubtful("Hello", ",").greet("World"))
    // apply method is special
    // it's called when the object is called like a function
    println(Greeters().greet("World"))
    println(Greeters.apply().greet("World"))

    // Case Classes
    val money     = Money(10)
    val moreMoney = Money(10)

    // case classes are compared by value
    println(money == moreMoney)

    val sum          = money.add(moreMoney).add(moreMoney)
    val tooMuchMoney = money + moreMoney
    println(tooMuchMoney)

    // immutable fields
    val _100money = sum.copy(amount = 100)
    println(_100money)

    // Companion Object
    // it's an Object with the same name of the class/case class
    println(Money.zero)

    // have an apply method, generated by the compiler
    // which is used to create instances of case classes
    println(Money(10))
    println(Money.apply(10))
  }
}

// class definition with in line constructor
// w/ syntax sugar for getters and setters
// based on the presence (or not) of val and var
class Greeter(val prefix: String, separator: String = ".", var suffix: String) {

  def greet(name: String): String =
    // string interpolation
    s"$prefix$separator $name$suffix"
}

object Greeters {
  // object can have methods
  def assertive(prefix: String, separator: String): Greeter =
    new Greeter(prefix, separator, "!")

  def doubtful(prefix: String, separator: String): Greeter =
    new Greeter(prefix, separator, "?")

  def apply(): Greeter =
    new Greeter("Hello", ",", "!")
}

case class Money(amount: Int) {

  // method
  def add(m: Money): Money =
    Money(amount + m.amount)

  // operator
  def +(m: Money): Money =
    Money(amount + m.amount)
}

object Money {
  // object can have fields
  val zero = new Money(0)
}
