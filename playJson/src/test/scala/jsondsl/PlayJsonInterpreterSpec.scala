package jsondsl

import org.scalatest.FunSuite
import play.api.libs.json.Json

class PlayJsonInterpreterSpec extends FunSuite {
  import PlayJsonInterpreter.playJsonJsonSym

  test("obj syntax") {
    assert(SampleJson.jsonObject ===
      Json.obj(
        "string" -> "hello",
        "int" -> 100,
        "long" -> 100L,
        "float" -> 1.1f,
        "double" -> 2.2d,
        "big_decimal" -> BigDecimal(10),
      )
    )
  }

  test("arr syntax") {
    assert(SampleJson.jsonObject === Json.arr(1, 1.1, "foo"))
  }
}
