package jsondsl

object StringInterpreter {
  implicit val stringJsonSym: JsonSym[Id, String] = new StringJsonSym
}

private class StringJsonSym extends JsonSym[Id, String] {

  def str(s: String): String = "\"" + s + "\""

  def num(i: Int): String = i.toString
  def num(l: Long): String = l.toString
  def num(f: Float): String = f.toString
  def num(d: Double): String = d.toString
  def num(b: BigDecimal): String = b.toString

  def obj(ps: (String, String)*): String =
    ps.map { case (k, v) => s""""$k": $v""" }.mkString("{", ", ", "}")

  def arr(vs: String*): String = vs.mkString("[", ", ", "]")
}
