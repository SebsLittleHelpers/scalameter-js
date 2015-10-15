import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt._
import Keys._

object ScalaMeterJsBuild extends Build {

  lazy val scalaMeterJsDependencies = Def.setting(Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.8.2",
    "com.lihaoyi" %%% "utest" % "0.3.0" % "test"))

  lazy val scalaMeterJsSettings = Defaults.coreDefaultSettings ++ Seq(
    name := "scalameter-js",
    normalizedName := "scalameter-js",
    scalaVersion := "2.11.7",
    version := "0.0.1-SNAPSHOT",
    persistLauncher in Compile := true,
    mainClass in Compile := Some("example.Main"),
    scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-Xfatal-warnings"),
    licenses += ("MIT", url("http://opensource.org/licenses/mit-license.php")),
    libraryDependencies ++= scalaMeterJsDependencies.value)

  lazy val scalaMeterJs = Project(
    id = "scalameter-js",
    base = file("."),
    settings = scalaMeterJsSettings).enablePlugins(ScalaJSPlugin)
} 

