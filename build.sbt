enablePlugins(ScalaJSPlugin)

name := "scalajs-scalameter"

normalizedName := "scalajs-scalameter"

scalaVersion := "2.11.7"

version := "0.0.1-SNAPSHOT"

persistLauncher in Compile := true

scalacOptions ++= Seq("-deprecation", "-feature", "-Xfatal-warnings")

licenses += ("MIT", url("http://opensource.org/licenses/mit-license.php"))

libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.8.2",
    "com.lihaoyi" %%% "utest" % "0.3.0" % "test"
)
