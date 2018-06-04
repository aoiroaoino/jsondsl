package jsondsl

trait JsonSym[F[_], Json] {

  def str(s: String): F[Json]

  def num(i: Int): F[Json]
  def num(l: Long): F[Json]
  def num(f: Float): F[Json]
  def num(d: Double): F[Json]
  def num(b: BigDecimal): F[Json]

  def obj(ps: (String, F[Json])*): F[Json]

  def arr(vs: F[Json]*): F[Json]
}

object JsonSym {

  def str[F[_], Json](s: String)(implicit sym: JsonSym[F, Json]): F[Json] = sym.str(s)

  def num[F[_], Json](i: Int)(implicit sym: JsonSym[F, Json]): F[Json] = sym.num(i)
  def num[F[_], Json](l: Long)(implicit sym: JsonSym[F, Json]): F[Json] = sym.num(l)
  def num[F[_], Json](f: Float)(implicit sym: JsonSym[F, Json]): F[Json] = sym.num(f)
  def num[F[_], Json](d: Double)(implicit sym: JsonSym[F, Json]): F[Json] = sym.num(d)
  def num[F[_], Json](b: BigDecimal)(implicit sym: JsonSym[F, Json]): F[Json] = sym.num(b)

  def obj[F[_], Json](ps: (String, F[Json])*)(implicit sym: JsonSym[F, Json]): F[Json] = sym.obj(ps: _*)

  def arr[F[_], Json](vs: F[Json]*)(implicit sym: JsonSym[F, Json]): F[Json] = sym.arr(vs: _*)
}
