package jsondsl

import org.scalatest.FunSuite

class StringInterpreterSpec extends FunSuite {
  import StringInterpreter.stringJsonSym

  test("obj syntax") {
    assert(SampleJson.jsonObject ===
      """{"string": "hello", "int": 100, "long": 100, "float": 1.1, "double": 2.2, "big_decimal": 10}""")
  }

  test("arr syntax") {
    assert(SampleJson.jsonArray === """[1, 1.1, "foo"]""")
  }
}
