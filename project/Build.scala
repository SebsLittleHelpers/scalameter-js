import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt._
import Keys._

object ScalaMeterJsBuild extends Build {

  lazy val commonSettings = Defaults.coreDefaultSettings ++ Seq( 
    scalaVersion := "2.11.7",
    scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-Xlint", "-Xfatal-warnings"),
    maxErrors := 5
  )

  lazy val scalaMeterJsDependencies = Def.setting(Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.8.2",
    "com.lihaoyi" %%% "utest" % "0.3.0" % "test"
  ))

  lazy val scalaMeterJsSettings = commonSettings ++ Seq(
    name := "scalameter-js",
    normalizedName := "scalameter-js",
    organization := "org.sebs.little.helpers",
    version := "0.0.1-SNAPSHOT",
    persistLauncher in Compile := true,
    mainClass in Compile := Some("example.Main"),
    licenses += ("MIT", url("http://opensource.org/licenses/mit-license.php")),
    libraryDependencies ++= scalaMeterJsDependencies.value
  )

  val scalaMeterCoreSettings = commonSettings ++ Seq(
    name := "scalameter-core",
    organization := "com.storm-enroute",
    jsDependencies += "org.webjars.bower" % "jstat" % "1.3.0" / "jstat.js" minified "jstat.min.js",
    skip in packageJSDependencies := false
  )

  lazy val scalaMeterDependencies = Def.setting(Seq(
    "org.scala-js" % "scala-parser-combinators_sjs0.6_2.11" % "1.0.2"
  ))

  val scalaMeterSettings = commonSettings ++ Seq(
    name := "scalameter",
    organization := "com.storm-enroute",
    libraryDependencies ++= scalaMeterDependencies.value
  )

  val javalibSettings = commonSettings ++ Seq(
    name := "javalib"
  )

  lazy val javalib = Project(
    "javalib",
    file("javalib"),
    settings = javalibSettings 
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
    javalib
  )

  lazy val scalaMeter = Project(
    "scalameter",
    file("scalameter"),
    settings = scalaMeterSettings 
  ) enablePlugins (
    ScalaJSPlugin
  ) dependsOn (
    scalaMeterCore
  ) aggregate ( scalaMeterCore, javalib ) 


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

