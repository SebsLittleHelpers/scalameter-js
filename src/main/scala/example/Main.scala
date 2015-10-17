package example

import scala.scalajs.js
import org.scalajs.dom
import org.scalameter.api._
import org.scalameter.picklers.noPickler._

/**
 * @author dengels
 */
object Main extends js.JSApp {

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
    
    override def reporter = Reporter.None
    override def executor = LocalExecutor(warmer, aggregator, measurer)
    override def persistor = Persistor.None
  }

  def main: Unit = {
    println("Hello World")
    RangeBenchmark.main(Array())
  }
}