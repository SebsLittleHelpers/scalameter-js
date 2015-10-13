package newcore

import scala.scalajs.js
import js.annotation.JSName


trait ScalaMeter {
  val defaultIter = 10000

  def measure (instrs: => Unit)(implicit iter: Int = defaultIter) : Double = {
    val times = for { x <- 0 until iter} yield {
      if (x % (iter / 10) == 0) println("Iter " + x + " out of " + iter)
      val timer = new Timer()
      timer.start()
      instrs
      timer.stop()
      timer.microseconds
    }

    val min = times.min
    val mean = times.sum / times.size
    val median = times.sorted.apply(times.size/2)

    println("Minimum running time was: " + min + " μs")
    println("Average running time was: " + mean + " μs")
    println("Median running time was: " + median + " μs")
    median
  }
}
