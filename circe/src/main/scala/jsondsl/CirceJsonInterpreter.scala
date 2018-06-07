package jsondsl

import io.circe._

object CirceInterpreter {
  implicit val circeJsonSym: JsonSym[Id, Json] = new CirceJsonSym
}

private class CirceJsonSym extends JsonSym[Id, Json] {

  def str(s: String): Json = Json.fromString(s)

  def num(i: Int): Json = Json.fromInt(i)
  def num(l: Long): Json = Json.fromLong(l)
  def num(f: Float): Json = Json.fromFloatOrString(f)
  def num(d: Double): Json = Json.fromDoubleOrString(d)
  def num(b: BigDecimal): Json = Json.fromBigDecimal(b)

  def obj(ps: (String, Json)*): Json = Json.obj(ps: _*)

  def arr(vs: Json*): Json = Json.arr(vs: _*)
}
