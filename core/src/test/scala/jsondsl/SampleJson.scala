package jsondsl

object SampleJson {

  def jsonObject[F[_], Json](implicit sym: JsonSym[F, Json]): F[Json] = {
    import sym._
    obj(
      "string" -> "hello",
      "int" -> 100,
      "long" -> 100L,
      "float" -> 1.1f,
      "double" -> 2.2d,
      "big_decimal" -> BigDecimal(10),
    )
  }

  def jsonArray[F[_], Json](implicit sym: JsonSym[F, Json]): F[Json] = {
    import sym._
    arr(1, 1.1, "foo")
  }
}
