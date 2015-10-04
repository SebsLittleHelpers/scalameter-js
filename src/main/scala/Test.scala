import scala.scalajs.js

object Test extends js.JSApp with ScalaMeter {

  def main: Unit = {
    measure {
      (0 to 10000).toList.map(x => x * x * x).sum
    }
  }
}
