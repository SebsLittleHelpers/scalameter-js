lazy val root = project.in(file(".")).
  enablePlugins(ScalaJSPlugin)

name := "Scala.js Scalameter"

normalizedName := "scalajs-scalameter"

scalaVersion := "2.11.7"

scalacOptions ++= Seq("-deprecation", "-feature", "-Xfatal-warnings")

licenses += ("MIT", url("http://opensource.org/licenses/mit-license.php"))
