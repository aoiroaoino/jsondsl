package jsondsl

import io.circe.Json
import org.scalatest.FunSuite

class CirceJsonInterpreterSpec extends FunSuite {
  import CirceInterpreter.circeJsonSym

  test("obj syntax") {
    assert(SampleJson.jsonObject ===
      Json.obj(
        "string" -> Json.fromString("hello"),
        "int" -> Json.fromInt(100),
        "long" -> Json.fromLong(100L),
        "float" -> Json.fromFloatOrString(1.1f),
        "double" -> Json.fromDoubleOrString(2.2d),
        "big_decimal" -> Json.fromBigDecimal(BigDecimal(10))
      )
    )
  }

  test("arr syntax") {
    assert(SampleJson.jsonArray ===
      Json.arr(
        Json.fromInt(1),
        Json.fromDoubleOrString(1.1),
        Json.fromString("foo")
      )
    )
  }
}
