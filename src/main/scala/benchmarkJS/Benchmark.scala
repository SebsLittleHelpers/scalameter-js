package benchmarkJS

import scala.scalajs.js
import org.scalajs.dom

@js.native
object Benchmark extends js.Object {

  @js.native
  class Suite extends js.Array[Benchmark]{
    def add(testName: String, snippet: js.Function0[_]): Suite = js.native

    def on(eventName: String, callback: js.Function0[_]): Suite = js.native
    def on(eventName: String, callback: js.Function1[dom.Event, _]): Suite = js.native
    
    def on(eventName: String, callback: js.ThisFunction0[Suite, _]): Suite = js.native
    def on(eventName: String, callback: js.ThisFunction1[Suite, dom.Event, _]): Suite = js.native


    def run(params: js.Dictionary[_]): Suite = js.native

    def filter(field : String): Suite = js.native
    def pluck(field : String): js.Array[_] = js.native
  }

}

@js.native
class Benchmark extends js.Object {
    val name : String = js.native
    val hz : Double = js.native
}



