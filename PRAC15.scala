import scala.io.Source

object PRAC15 {
  def main(args: Array[String]): Unit = {

    val source = Source.fromResource("polynomial.csv")

    val numbers = source.getLines()
      .drop(1)
      .map(_.trim.toInt)
      .toList

    source.close()

    val polynomialFeatures = numbers.flatMap { x =>
      List(x, x * x, x * x * x)
    }

    println("Original Data:")
    println(numbers)

    println()
    println("Polynomial Features up to Degree 3:")
    println(polynomialFeatures)
  }
}