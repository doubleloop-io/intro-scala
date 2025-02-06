package io.doubleloop.basic

object DemoExpression {

  def run(): Unit = {
    // val is immutable
    // type defined with inference
    val x = 1

    // specified type
    // https://docs.scala-lang.org/tour/unified-types.html
    val y: Int = 2

    // All types in Scala are objects,
    // start with a capital letter
    // and have methods

    // var is mutable
    var z = x + y

    // re-assign z
    z = 123

    // everything is an expression
    // that will be evaluated to a value
    // even "void" methods like println
    // that are functions returning Unit
    val result = println(z)

    println(result)

    // block expression
    // like an inline expression
    // that will be evaluated
    println {
      val a = 1
      val b = 2
      a + b
    }

    // very useful for DSLs
    val person = aPerson {
      withAddress {
        "Via Verdi"
      }
    }
    println(person)

    // function definition w/
    // defined arguments type and
    // inferred return type
    val add = (a: Int, b: Int) => a + b

    // explicit function types
    val add2: (Int, Int) => Int = (a, b) => a + b

    // function application...
    println(add2(1, 2))
    // ...it's syntax sugar for
    println(add2.apply(1, 2))

    // methods are applied like functions
    println(addThenMultiply(1, 2)(3))

    // methods w/ multiple parameter lists
    // can be partially applied
    val multiply = addThenMultiply(1, 2) _
    println(multiply(3))

    // a method w/out parameter is
    // like a field lazy initialized
    println("Hello, " + name + "!")

    val value = 3

    // even the if is an expression
    val prefixIf = if (value % 2 == 0) {
      "even"
    } else {
      "odd"
    }

    // even the match is an expression
    val prefixMatch = value % 2 == 0 match {
      case true => "even"
      case _    => "odd"
    }
  }

  // any def definition inside an object or a class
  // is a method and by default it is public
  def aPerson(value: String): String =
    value.toUpperCase()

  // make it private or protected
  private def withAddress(value: String): String =
    value.prependedAll("Address: ")

  // a method can take multiple parameter lists
  private def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int =
    (x + y) * multiplier

  // or no parameter lists at all
  private def name: String =
    "John Doe"

  // Scala can interact with Java standard library
  def userName: String =
    System.getProperty("user.name")
}
