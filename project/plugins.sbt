addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.0.0")
//addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.19.0")
addSbtPlugin("org.scala-js" % "sbt-jsdependencies" % "1.0.2")

libraryDependencies += "org.scala-js" %% "scalajs-env-jsdom-nodejs" % "1.0.0"

addSbtPlugin("com.codecommit" % "sbt-github-packages" % "0.5.2")