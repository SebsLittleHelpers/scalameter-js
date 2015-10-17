import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt._
import Keys._

object ScalaMeterJsBuild extends Build {

  lazy val commonSettings = Defaults.coreDefaultSettings ++ Seq( 
    scalaVersion := "2.11.7",
    scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-Xlint", "-Xfatal-warnings"),
    maxErrors := 5,
    scalaJSOptimizerOptions ~= { _.withDisableOptimizer(true) }
  )

  lazy val scalaMeterJsDependencies = Def.setting(Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.8.2",
    "com.lihaoyi" %%% "utest" % "0.3.0" % "test"
  ))

  lazy val scalaMeterJsSettings = commonSettings ++ Seq(
    name := "scalameter-js",
    normalizedName := "scalameter-js",
    version := "0.0.1-SNAPSHOT",
    persistLauncher in Compile := true,
    mainClass in Compile := Some("example.Main"),
    licenses += ("MIT", url("http://opensource.org/licenses/mit-license.php")),
    libraryDependencies ++= scalaMeterJsDependencies.value
  )

  val scalaMeterCoreSettings = commonSettings ++ Seq(
    name := "scalameter-core",
    organization := "com.storm-enroute"
  )

  lazy val scalaMeterDependencies = Def.setting(Seq(
    "org.scala-js" % "scala-parser-combinators_sjs0.6_2.11" % "1.0.2"
  ))

  val scalaMeterSettings = commonSettings ++ Seq(
    name := "scalameter",
    organization := "com.storm-enroute",
    libraryDependencies ++= scalaMeterDependencies.value
  )

  val javajsSettings = commonSettings ++ Seq(
    name := "javajs"
  )

  lazy val javajs = Project(
    "javajs",
    file("javajs"),
    settings = javajsSettings 
  ) enablePlugins (
    ScalaJSPlugin
  )

  lazy val scalaMeterCore = Project(
    "scalameter-core",
    file("scalameter-core"),
    settings = scalaMeterCoreSettings 
  ) enablePlugins (
    ScalaJSPlugin
  ) dependsOn (
    javajs
  )

  lazy val scalaMeter = Project(
    "scalameter",
    file("scalameter"),
    settings = scalaMeterSettings 
  ) enablePlugins (
    ScalaJSPlugin
  ) dependsOn (
    scalaMeterCore
  ) 


  lazy val scalaMeterJs = Project(
    id = "scalameter-js",
    base = file("."),
    settings = scalaMeterJsSettings
  ) enablePlugins (
    ScalaJSPlugin
  ) dependsOn (
    scalaMeter
  )
} 

