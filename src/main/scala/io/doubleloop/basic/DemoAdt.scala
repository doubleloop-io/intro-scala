package io.doubleloop.basic

object DemoAdt {

  def run(): Unit = {
    println((10, 20))
    println(ProductType.Person("Alice", 30))
    println(ProductType.Car(ProductType.Engine(100), List(ProductType.Wheel(10, 2, "Michelin", 20))))

    println(SumType.EUR)
    println(SumType.Just("Hello"))
    println(SumType.Nothing)
  }

  object ProductType {

    type Point = (Int, Int)

    case class Person(name: String, age: Int)

    case class Engine(hp: Int)
    case class Wheel(width: Int, ratio: Int, model: String, rimSize: Int)
    case class Car(engine: Engine, wheels: List[Wheel])
  }

  object SumType {

    sealed trait Currency
    object USD extends Currency
    object EUR extends Currency

    sealed trait Maybe[+A]
    case class Just[A](value: A) extends Maybe[A]
    case object Nothing          extends Maybe[Nothing]
  }
}
