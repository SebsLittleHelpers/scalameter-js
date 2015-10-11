package newcore

import scala.scalajs.js
import js.annotation.JSName

@JSName("chrome.Interval")
@js.native
class Timer extends js.Object {
  def start: js.Function0[js.Any] = js.native
  def stop: js.Function0[js.Any] = js.native
  def milliseconds(): Double = js.native
  def microseconds(): Double = js.native
}
