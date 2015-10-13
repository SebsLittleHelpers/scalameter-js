package newcore

import scala.scalajs.js
import org.scalajs.dom
import benchmarkjs._
import utils._
import scala.util.Random

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
      println(message)
    }
    
    def buildTable(implName : Seq[String], data : Seq[(String, Seq[(String, Double)])]) : Unit  = {
      //op -> impl -> time
      val th = ("<td></td>" +: implName.map(x => s"<td> $x </td>")).mkString("<tr>", "\n", "</tr>")
      val tr = for((name, bench) <- data) yield {
        val min = bench.map(_._2).min
         (s"<td> $name </td>" +: bench.map(x => if(x._2 == min) s"<td class='text-success'> ${x._2} </td>" else s"<td> ${x._2} </td>")).mkString("<tr>", "\n", "</tr>")
      }
      echo("<table class='table'>" + th + tr.mkString("\n") + "</table>")
      
    }

    echo("Running tests ...")

    val suite = new Suite()

    type RuntimeLong = Long

    val operations: Seq[(String, (RuntimeLong, RuntimeLong) => RuntimeLong)] = 
      Seq(("plus", _ + _),
          ("times", _ * _),
          ("mod", _ % _), 
          ("div", _ / _))

    val implementations: Seq[(String, Long => RuntimeLong)] = Seq(("simple", x => x), ("double", x => x * 2))

    val rand = new Random()
    val operands: Gen[(Long, Long)] = Gen.pairs(Gen.random[Long], Gen.random[Long])

    val results = for ((name, op) <- operations) yield {
      
      val runTimes : Seq[(String, Double)] = for ((name, impl) <- implementations) yield {
        val timeToRun = measure {
          for ((a, b) <- operands.toIterator.take(5)) {
            op(impl(a), impl(b))
          }
        }(100)
        
        (name -> timeToRun)
      }
      
      (name -> runTimes)  
    }
    
    /*results.foreach{
      case (name, bench) => 
        echo(s"$name -> ")
        bench.foreach {
          case (name, ttr) => echo(s"   $name : $ttr")
        }
    }*/
    
    buildTable(implementations.map(_._1), results)
    
    

    /*val sizes = Gen.range("sizes")(10, 30, 1)
    val ranges: Gen[Range] = for {
      size <- sizes
    } yield 0 until size
    
    echo(ranges.dataset.mkString(" - "))*/

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
      .on("complete", (suite: Suite) => {
        echo("Fastest is " + suite.filter("fastest").pluck("name"))
      })
      .run(js.Dictionary("async" -> true))
  }

}
