package org.scalameter

/** Import the contents of this singleton object to obtain access to most abstractions
 *  in the ScalaMeter API.
 *
 *  Note that some definitions might shadow others, so if you import the contents of this
 *  object, you should not import the contents of other packages directly.
 *
 *  This object contains:
 *  - basic datatypes and singleton objects for writing tests, such as `PerformanceTest`
 *  - all the context map keys
 *  - contents of the `execution` package
 *  - contents of the `reporting` package
 *  - contents of the `persistence` package
 *  - the `Executor.Measurer` object
 *  - the `RegressionReporter.Tester` object
 *  - the `RegressionReporter.Historian` object
 *  - the `ChartReporter.ChartFactory` object
 *  - the `HtmlReporter.Renderer` object
 *  - and much more...
 */
object api extends Keys {

  type Gen[T] = org.scalameter.Gen[T]
  val Gen = org.scalameter.Gen

  type Context = org.scalameter.Context
  val Context = org.scalameter.Context

  type Bench[T] = org.scalameter.Bench[T]
  val Bench = org.scalameter.Bench

  @deprecated("Please use Bench instead", "0.7")
  type PerformanceTest[T] = org.scalameter.Bench[T]
  @deprecated("Please use Bench instead", "0.7")
  val PerformanceTest = org.scalameter.Bench

  type Executor[T] = org.scalameter.Executor[T]
  val Executor = org.scalameter.Executor

  type Reporter[T] = org.scalameter.Reporter[T]
  val Reporter = org.scalameter.Reporter

  type Persistor = org.scalameter.Persistor
  val Persistor = org.scalameter.Persistor

  /* execution */

  val LocalExecutor = execution.LocalExecutor
  // TODO : val SeparateJvmsExecutor = execution.SeparateJvmsExecutor

  val Aggregator = org.scalameter.Aggregator
  val Warmer = org.scalameter.Warmer
  val Measurer = org.scalameter.Measurer

  type Aggregator[T] = org.scalameter.Aggregator[T]
  type Warmer = org.scalameter.Warmer
  type Measurer[T] = org.scalameter.Measurer[T]

  /* reporting */

  // TODO : type ChartReporter[T] = reporting.ChartReporter[T]
  // TODO : val ChartReporter = reporting.ChartReporter

  // TODO : type HtmlReporter[T] = reporting.HtmlReporter[T]
  // TODO : val HtmlReporter = reporting.HtmlReporter

  type LoggingReporter[T] = reporting.LoggingReporter[T]
  val LoggingReporter = reporting.LoggingReporter

  type RegressionReporter[T] = reporting.RegressionReporter[T]
  val RegressionReporter = reporting.RegressionReporter

  // TODO : type DsvReporter[T] = reporting.DsvReporter[T]
  // TODO : val DsvReporter = reporting.DsvReporter

  val Tester = reporting.RegressionReporter.Tester
  val Historian = reporting.RegressionReporter.Historian
  // TODO : val ChartFactory = reporting.ChartReporter.ChartFactory

  /* persistence */

  type SerializationPersistor = persistence.SerializationPersistor
  val SerializationPersistor = persistence.SerializationPersistor

  // TODO : type JSONSerializationPersistor = persistence.JSONSerializationPersistor
  // TODO : val JSONSerializationPersistor = persistence.JSONSerializationPersistor

  // TODO : type GZIPJSONSerializationPersistor = persistence.GZIPJSONSerializationPersistor
  // TODO : val GZIPJSONSerializationPersistor = persistence.GZIPJSONSerializationPersistor

  /* annotation based frontend */

  // TODO : type benchmark = japi.annotation.benchmark
  // TODO : type ctx = japi.annotation.ctx
  // TODO : type curve = japi.annotation.curve
  // TODO : type gen = japi.annotation.gen
  // TODO : type scopeCtx = japi.annotation.scopeCtx
  // TODO : type scopes = japi.annotation.scopes
  // TODO : type setup = japi.annotation.setup
  // TODO : type setupBeforeAll = japi.annotation.setupBeforeAll
  // TODO : type teardown = japi.annotation.teardown
  // TODO : type teardownAfterAll = japi.annotation.teardownAfterAll
  // TODO : type warmup = japi.annotation.warmup
}
