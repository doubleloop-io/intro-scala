package io.doubleloop.basic

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success, Try}

object DemoError {

  def run(): Unit = {
    ClassicErrorHandling.runBoom()
//    ClassicErrorHandling.runCatch()
//    DynamicErrorHandling.runTry()
//    DynamicErrorHandling.runFuture()
//    StaticErrorHandling.runEither()
//    StaticErrorHandling.runEitherThrowable()
  }

  private object ClassicErrorHandling {

    private def compute(magicValue: Int): Int =
      if (magicValue > 0) magicValue * 2
      else throw new RuntimeException("invalid number")

    def runBoom() = {
      val value = compute(-10)
      println("After compute")
    }

    def runCatch() =
      try {
        val value = compute(-10)
        println("After compute")
      } catch {
        case e: RuntimeException => println(s"Error: ${e.getMessage}")
      }
  }

  private object DynamicErrorHandling {

    private def computeTry(magicValue: Int): Try[Int] =
      if (magicValue > 0) Success(magicValue * 2)
      else Failure(new RuntimeException("invalid number"))

    def runTry() = {
      val value = computeTry(-10)
      println("After compute")
      value.get
      println("After effect evaluation")
    }

    private def computeFuture(magicValue: Int): Future[Int] =
      if (magicValue > 0) Future.successful(magicValue * 2)
      else Future.failed(new RuntimeException("invalid number"))

    def runFuture() = {
      val value = computeFuture(-10)
      println("After compute")
      Await.result(value, 2.seconds)
      println("After effect evaluation")
    }

  }

  private object StaticErrorHandling {

    private def computeEither(magicValue: Int): Either[String, Int] =
      if (magicValue > 0) Right(magicValue * 2)
      else Left("invalid number")

    def runEither() = {
      val value = computeEither(-10)
      println("After compute")
      // there isn't a way to evaluate the effect
      // and receive an unhandled exception.
      // the error is a materialized value (string)
      // so we explicit it in the type signature
      // and we need to handle it explicitly
      value.getOrElse(42)
      println("After effect evaluation")
    }

    private def computeEitherThrowable(magicValue: Int): Either[Throwable, Int] =
      if (magicValue > 0) Right(magicValue * 2)
      else Left(new RuntimeException("invalid number"))

    def runEitherThrowable() = {
      val value = computeEitherThrowable(-10)
      println("After compute")
      // there isn't a way to evaluate the effect
      // and receive an unhandled exception.
      // the error is a materialized value (throwable)
      // so we explicit it in the type signature
      // and we need to handle it explicitly.
      value.getOrElse(42)
      println("After effect evaluation")
    }

  }
}
