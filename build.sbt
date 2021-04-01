name := "peer-scalajs"
organization := "com.nicolaswinsten"
version := "0.1"
scalaVersion := "2.13.5"

enablePlugins(ScalaJSPlugin)

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "1.0.0"

githubTokenSource := TokenSource.GitConfig("github.token")
githubOwner := "NicolasWinsten"
githubRepository := "peer-scalajs"
