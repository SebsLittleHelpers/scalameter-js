import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt._
import Keys._

object ScalaMeterJsBuild extends Build {

  val compilerOptions = Seq("-deprecation", "-unchecked", "-feature", "-Xlint", "-Xfatal-warnings")

  lazy val scalaMeterJsDependencies = Def.setting(Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.8.2",
    "com.lihaoyi" %%% "utest" % "0.3.0" % "test"
  ))

  lazy val scalaMeterJsSettings = Defaults.coreDefaultSettings ++ Seq(
    name := "scalameter-js",
    normalizedName := "scalameter-js",
    scalaVersion := "2.11.7",
    version := "0.0.1-SNAPSHOT",
    persistLauncher in Compile := true,
    mainClass in Compile := Some("example.Main"),
    scalacOptions ++= compilerOptions,
    maxErrors := 5,
    licenses += ("MIT", url("http://opensource.org/licenses/mit-license.php")),
    libraryDependencies ++= scalaMeterJsDependencies.value
  )



  val scalaMeterCoreSettings = Defaults.coreDefaultSettings ++ Seq(
    name := "scalameter-core",
    organization := "com.storm-enroute",
    scalaVersion := "2.11.7",
    scalacOptions ++= compilerOptions,
    maxErrors := 5
  )

  lazy val scalaMeterDependencies = Def.setting(Seq(
    "org.scala-js" % "scala-parser-combinators_sjs0.6_2.11" % "1.0.2"
  ))

  val scalaMeterSettings = Defaults.coreDefaultSettings ++ Seq(
    name := "scalameter",
    organization := "com.storm-enroute",
    scalaVersion := "2.11.7",
    scalacOptions ++= compilerOptions,
    maxErrors := 5,
    libraryDependencies ++= scalaMeterDependencies.value
  )


  lazy val scalaMeterCore = Project(
    "scalameter-core",
    file("scalameter-core"),
    settings = scalaMeterCoreSettings 
  ) enablePlugins (
    ScalaJSPlugin
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

