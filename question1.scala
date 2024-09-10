object Q1 extends App {
  val rational1 = new Rational(1, 3)
  val rational2 = new Rational(3, 7)
  println(s"Negation of $rational1: ${rational1.neg}")
  val q = rational1.add(rational2)
  println(s"Addition of $rational1 and $rational2: $q")
}

class Rational(x: Int, y: Int) {
 
  require(y != 0, "Denominator must be non-zero")


  val numer: Int = x
  val denom: Int = y

 
  def add(r: Rational): Rational = {
    new Rational(this.numer * r.denom + this.denom * r.numer, this.denom * r.denom)
  }

  
  def neg: Rational = new Rational(-this.numer, this.denom)


  override def toString(): String = s"$numer/$denom"
}