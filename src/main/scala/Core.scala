
import scala.scalajs.js
import js.annotation.JSName


trait ScalaMeter {
  def measure (iter: Int)(instrs: => Unit) {
    val times = (for { x <- 0 until iter} yield {
      println("Iter " + x + " out of " + iter)
      val startingPoint = new js.Date()
      instrs
      val endingPoint = new js.Date()
      (endingPoint.getMilliseconds() - startingPoint.getMilliseconds()).toDouble
    }).filter( x => x >= 0)

    val min = times.min
    val mean = times.sum / times.size
    val median = times.sorted.apply(times.size/2)

    println(times)
    println("Minimum running time was: " + min + " ms")
    println("Average running time was: " + mean + " ms")
    println("Median running time was: " + median + " ms")
  }
}
