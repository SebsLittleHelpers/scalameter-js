enablePlugins(ScalaJSPlugin)

name := "Test"

normalizedName := "scalajs-scalameter"

scalaVersion := "2.11.7"

version := "0.0.1-SNAPSHOT"

persistLauncher in Compile := true

scalacOptions ++= Seq("-deprecation", "-feature", "-Xfatal-warnings")

licenses += ("MIT", url("http://opensource.org/licenses/mit-license.php"))
