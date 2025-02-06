# Intro Scala

## SBT Commands

Enter SBT interactive shell

```sh
$ sbt
```

Common useful operations:

- `projects`: List all projects and mark the current one
- `project <NAME>`: Switch the current project to <NAME>
- `clean`: Deletes all generated files from compilation
- `compile`: Compiles the main sources (in src/main/scala) of the current project
- `console`: Open the REPL with the current project loaded
- `run`: Run the main (in src/main/scala) of the current project
- `test`: Compiles (main and test sources) and runs all tests
- `testOnly`: Compiles (main and test sources) and runs matching tests
- `scalafmtAll`: Format code for all configurations and projects

Run multiple commands:

```sh
>;clean;compile;test
```

Prepend `~` to any command to run it in watch mode. It can be used with one command:

```sh
>~test
```

or with many commands:

```sh
>~;scalafmtAll;clean;test
```

## SBT Aliases

From the SBT interactive shell:

- `c`: Compiles the main sources (in src/main/scala) of the current project
- `cc`: Clean and compiles the main sources (in src/main/scala) of the current project
- `cn`: Open the REPL with the current project loaded
- `r`: Run the main (in src/main/scala) of the current project
- `t`: Compiles (main and test sources) and runs all tests
- `to`: Compiles (main and test sources) and runs matching tests
- `fm`: Format code for all configurations and projects

## Documentation

Useful documentations:

- [Scala](https://docs.scala-lang.org/)
- [Scala Standard Library](https://www.scala-lang.org/files/archive/api/2.13.16/)
- [Tour of Scala](https://docs.scala-lang.org/tour/tour-of-scala.html)
- [SBT](https://www.scala-sbt.org/)
- [Metals](https://scalameta.org/metals/)
- [Scalafmt](https://scalameta.org/scalafmt/)
- [MUnit](https://scalameta.org/munit/docs/getting-started.html)
- [Scastie - Scala Online REPL](https://scastie.scala-lang.org/)
