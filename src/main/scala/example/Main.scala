package example

import scala.scalajs.js
import org.scalajs.dom
import org.scalameter.api._
import org.scalameter.picklers.noPickler._
import org.scalameter.utils.Tree
import org.scalameter.CurveData

/**
 * @author dengels
 */
object Main extends js.JSApp {

  def echo(message: String): Unit = {
    val paragraph = dom.document.createElement("p")
    paragraph.innerHTML = "<strong>" + message + "</strong>"
    dom.document.getElementById("playground").appendChild(paragraph)
    println(message)
  }

  object RangeBenchmark extends Bench.OfflineReport {

    val sizes = Gen.range("size")(300000, 1500000, 300000)

    val ranges: Gen[Range] = for {
      size <- sizes
    } yield 0 until size

    performance of "Range" config
      (exec.minWarmupRuns -> 1,
        exec.maxWarmupRuns -> 1,
        exec.benchRuns -> 1,
        exec.independentSamples -> 1) in {
          measure method "map" in {
            using(ranges) in {
              r => r map (_ + 1)
            }
          }
        }

    override def reporter = new Reporter[Double] {
      def report(result: CurveData[Double], persistor: Persistor): Unit = {
        println(s"\nOne Test finished : success = ${result.success}")

        println("\nContext:")
        val ctx = result.context
        ctx.properties.foreach { x => println(s"${x._1} -> ${x._2}") }

        println("\nInfo:")
        val info = result.info
        info.foreach { x => println(s"${x._1} -> ${x._2}") }

        println("\nMeasurements:")
        val measurements = result.measurements
        measurements.foreach { x => 
          val axisData = x.params.toString
          val result = x.value + x.units
          echo(s"$axisData : $result")
          }
      }

      def report(results: Tree[CurveData[Double]], persistor: Persistor): Boolean = {
        println("\n\nAll Test finished : ")

        true
      }

    }

    override def executor = LocalExecutor(warmer, aggregator, measurer)
    override def persistor = Persistor.None
  }

  def main: Unit = {
    println("Hello World")
    RangeBenchmark.main(Array())
  }
}