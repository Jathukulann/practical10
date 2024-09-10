object Q2 extends App {
  val x = new Rational(3, 5)
  val y = new Rational(5, 6)
  val z = new Rational(2, 5)

 
  val a = x - y - z
  
  println(s"Result of $x - $y - $z = $a")
}

class Rational(x: Int, y: Int) {
  
  require(y != 0, "Denominator must be non-zero")

  val numer: Int = x
  val denom: Int = y

  
  def neg: Rational = new Rational(-this.numer, this.denom)

  
  def add(r: Rational): Rational = {
    new Rational(this.numer * r.denom + this.denom * r.numer, this.denom * r.denom)
  }


  def -(r: Rational): Rational = {
    new Rational(this.numer * r.denom - this.denom * r.numer, this.denom * r.denom)
  }

  
  override def toString(): String = s"$numer/$denom"
}