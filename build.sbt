addCommandAlias("fm", "scalafmtAll;scalafmtSbt")
addCommandAlias("cc", "all clean compile")
addCommandAlias("cn", "console")
addCommandAlias("c", "compile")
addCommandAlias("r", "run")
addCommandAlias("t", "test")
addCommandAlias("to", "testOnly")

lazy val global = project
  .in(file("."))
  .settings(settings)

lazy val settings = Seq(
  name                     := "intro-scala",
  organization             := "io.doubleloop",
  scalaVersion             := "2.13.16",
  version                  := "0.1.0-SNAPSHOT",
  scalacOptions ++= scalacSettings,
  resolvers ++= resolversSettings,
  libraryDependencies ++= libsSettings,
  testFrameworks += new TestFramework("munit.Framework"),
  Test / parallelExecution := false,
  addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")
)

lazy val scalacSettings = Seq(
  "-encoding",
  "UTF-8",
  "-deprecation",
  "-unchecked",
  "-feature",
  "-explaintypes",
  "-opt-warnings",
  "-language:existentials",
  "-language:higherKinds",
  "-opt:l:inline",
  "-opt-inline-from:<source>",
  "-Yrangepos",
  "-Ywarn-numeric-widen",
  "-Ywarn-extra-implicit",
  "-Xlint:_,-type-parameter-shadow,-unused",
  "-Xfatal-warnings"
)

lazy val resolversSettings = (
  Resolver.sonatypeOssRepos("snapshots") ++
    Resolver.sonatypeOssRepos("releases")
).toSeq

lazy val libsSettings = Seq(
  "org.scalameta" %% "munit" % "1.1.0" % Test
)
