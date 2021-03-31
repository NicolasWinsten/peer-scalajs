name := "peer-scalajs"
organization := "com.nicolaswinsten"
version := "0.1"
scalaVersion := "2.13.3"

enablePlugins(ScalaJSPlugin)
//enablePlugins(ScalaJSBundlerPlugin)
enablePlugins(JSDependenciesPlugin)

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "1.0.0"
libraryDependencies += "com.lihaoyi" %%% "scalatags" % "0.9.1"

jsDependencies += ProvidedJS / "peerjs.min.js"
skip in packageJSDependencies in Compile := false

//scalaJSUseMainModuleInitializer := true
jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv()

//npmDependencies in Compile += "peerjs" -> "1.3.2"

githubTokenSource := TokenSource.GitConfig("github.token")
githubOwner := "NicolasWinsten"
githubRepository := "wiki"