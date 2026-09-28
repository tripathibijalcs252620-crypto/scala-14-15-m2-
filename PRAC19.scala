import scala.util.Random

object PRAC19 {
  def main(args: Array[String]): Unit = {

    val random = new Random()

    val sales = (1 to 30).map { day =>
      val amount = 1000 + random.nextInt(1001)
      (day, amount)
    }

    println("Daily Sales:")
    sales.foreach {
      case (day, amount) =>
        println(s"Day $day : Rs. $amount")
    }

    val totalSales = sales.map(_._2).sum
    val averageSales = totalSales.toDouble / sales.length
    val maximumSales = sales.map(_._2).max
    val minimumSales = sales.map(_._2).min

    println("\nTime Series Analysis:")
    println(s"Total Sales   : Rs. $totalSales")
    println(s"Average Sales : Rs. $averageSales")
    println(s"Maximum Sales : Rs. $maximumSales")
    println(s"Minimum Sales : Rs. $minimumSales")
  }
}