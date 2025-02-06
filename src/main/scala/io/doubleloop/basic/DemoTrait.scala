package io.doubleloop.basic

object DemoTrait {
  def run(): Unit = {
    val simpleGreeter = new SimpleGreeter()
    println(simpleGreeter.greet("World"))
    println(simpleGreeter.greetDefault("World"))

    val customGreeter = new CustomGreeter("Hey", "!")
    println(customGreeter.greet("World"))
    println(customGreeter.greetDefault("World"))

    val person = Person("Alice")
    println(person.greet("World"))
    println(person.upperize)
  }

  // define a contract
  trait Greeter {
    // method contract
    def greet(name: String): String

    // default value (field)
    val separator = ","

    // default method
    def greetDefault(name: String): String =
      s"Hello$separator $name!"
  }

  // implement the contract
  class SimpleGreeter extends Greeter {
    def greet(name: String): String =
      s"Hello, $name!"
  }

  // implement the contract and override the default method
  class CustomGreeter(val prefix: String, val suffix: String) extends Greeter {
    def greet(name: String): String =
      s"$prefix, $name$suffix"

    override def greetDefault(name: String): String =
      "I'm not saying hello"
  }

  // more contract
  trait Upperize {
    def upperize: String
  }

  //
  case class Person(name: String) extends Greeter with Upperize {
    override def greet(name: String): String =
      s"Hello, $name! By ${this.name}"

    def upperize: String =
      name.toUpperCase
  }
}
