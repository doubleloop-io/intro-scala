package io.doubleloop.basic

object DemoImplicit {

  trait Comparator[A] {
    def compare(x: A, y: A): Int
  }

  object Comparator {
    implicit object IntComparator extends Comparator[Int] {
      def compare(x: Int, y: Int): Int = Integer.compare(x, y)
    }

    implicit object StringComparator extends Comparator[String] {
      def compare(x: String, y: String): Int = x.compareTo(y)
    }
  }

  def max[A](x: A, y: A)(implicit comparator: Comparator[A]): A =
    if (comparator.compare(x, y) >= 0) x
    else y

  def run(): Unit = {
    println(max(10, 6))
    println(max("hello", "world"))
//    println(max(true, false))
  }

}
