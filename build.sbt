name := "rovers-simulator"

version := "1.0"

scalaVersion := "2.11.0"

scalacOptions := Seq("-unchecked", "-feature", "-deprecation", "-encoding", "utf8", "-Xfatal-warnings", "-language:postfixOps")


resolvers ++= Seq(
  "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/",
  "tpolecat" at "http://dl.bintray.com/tpolecat/maven"
)

libraryDependencies ++= Seq(
  // UTILS
  "org.scala-lang.modules"              %% "scala-parser-combinators" % "1.0.4",
  // TESTS
  "org.scalatest"                       %% "scalatest"                % "2.2.4"  % "test",
  "org.scalacheck"                      %% "scalacheck"               % "1.12.2" % "test"
)

parallelExecution in Test := false

mainClass in Compile := Some("Simulator")
