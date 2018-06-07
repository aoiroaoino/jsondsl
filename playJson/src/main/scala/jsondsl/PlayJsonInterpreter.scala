package jsondsl

import play.api.libs.json._
import play.api.libs.json.Json._

object PlayJsonInterpreter {
  implicit val playJsonJsonSym: JsonSym[Id, JsValue] = new PlayJsonJsonSym
}

private class PlayJsonJsonSym extends JsonSym[Id, JsValue] {

  def str(s: String): JsValue = JsString(s)

  def num(i: Int): JsValue = JsNumber(i)
  def num(l: Long): JsValue = JsNumber(l)
  def num(f: Float): JsValue = JsNumber(f)
  def num(d: Double): JsValue = JsNumber(d)
  def num(b: BigDecimal): JsValue = JsNumber(b)

  def obj(ps: (String, JsValue)*): JsValue =
    Json.obj(ps.map { case (k, v) => (k, v: JsValueWrapper) }: _*)

  def arr(vs: JsValue*): JsValue =
    Json.arr(vs.map(v => v: JsValueWrapper): _*)
}
