name := "peer-scalajs"
organization := "com.nicolaswinsten"
version := "0.1"
scalaVersion := "2.13.3"

enablePlugins(ScalaJSPlugin)

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "1.1.0"

ThisBuild / organization := "com.nicolaswinsten.peer-scalajs"
ThisBuild / organizationName := "nicolaswinsten"
ThisBuild / organizationHomepage := Some(url("http://nicolaswinsten.com/"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/NicolasWinsten/peer-scalajs"),
    "scm:git@github.com:NicolasWinsten/peer-scalajs.git"
  )
)

ThisBuild / developers := List(
  Developer(
    id    = "nicolaswinsten",
    name  = "Nicolas Winsten",
    email = "nicolasd.winsten@gmail.com",
    url   = url("http://nicolaswinsten.com")
  )
)
ThisBuild / description := "Scala.js facade over the PeerJS library."
ThisBuild / licenses += ("MIT License", url("http://www.opensource.org/licenses/mit-license.php"))
ThisBuild / homepage := Some(url("https://github.com/NicolasWinsten/peer-scalajs"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }

ThisBuild / publishTo := {
  val nexus = "https://s01.oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true
