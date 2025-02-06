package io.doubleloop

import java.nio.file.{Files, Path}

class MySuite extends munit.FunSuite {

  test("hello") {
    val obtained = 42
    val expected = 42
    assertEquals(obtained, expected)
  }

  test("hello again".ignore) {
    assertEquals(42, 42)
  }

//  test("hello fail".fail) {
//    assertEquals(43, 43)
//  }

  test("generic assertion") {
    assert(42 == 42)
  }

  // define how to setup and teardown external resource
  // https://scalameta.org/munit/docs/fixtures.html
  private val files = FunFixture[Path](
    setup = { test =>
      Files.createTempFile("tmp", test.name)
    },
    teardown = { file =>
      // Always gets called, even if test failed.
      Files.deleteIfExists(file)
    }
  )

  // use the fixture (resource)
  files.test("is regular file") { file =>
    assert(Files.isRegularFile(file), s"Files.isRegularFile($file)")
  }
  files.test("is regular file (2)") { file =>
    assert(Files.isRegularFile(file), s"Files.isRegularFile($file)")
  }
}
