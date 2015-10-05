import scala.scalajs.js
import org.scalajs.dom
import benchmarkJS._

object Test extends js.JSApp with ScalaMeter {

  def main: Unit = {
    method2
  }

  def method1(): Unit = {
    measure {
      (0 to 10000).toList.map(x => x * x * x).sum
    }
  }

  def method2(): Unit = {

    def echo(message: String): Unit = {
      val paragraph = dom.document.createElement("p")
      paragraph.innerHTML = "<strong>" + message + "</strong>"
      dom.document.getElementById("playground").appendChild(paragraph)
    }

    echo("Running tests ...")

    val suite = new Benchmark.Suite()

    suite
      .add("RegExp#test", () => {
        "o".r.findFirstIn("Hello World!").isDefined
      })
      .add("String#indexOf", () => {
        "Hello World!".indexOf('o') > -1;
      })
      .add("String#match", () => {
        "Hello World!".matches("o")
      })
      .on("cycle", (event: dom.Event) => {
        echo("<p>" + event.target + "</p>")
      })
      .on("complete", (suite: Benchmark.Suite) => {
        echo("Fastest is " + suite.filter("fastest").pluck("name"))
      })
      .run(js.Dictionary("async" -> true))
  }

}
