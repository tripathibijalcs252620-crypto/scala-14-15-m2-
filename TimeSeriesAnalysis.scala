import scala.io.Source

object TimeSeriesAnalysis {
  def main(args: Array[String]): Unit = {

    val source = Source.fromResource("train.csv")

    val data = source.getLines()
      .drop(1)
      .map { line =>
        val parts = line.split(",")
        val date = parts(0)
        val sales = parts(3).toInt
        (date, sales)
      }
      .toList

    source.close()

    val dailySales = data
      .groupBy(_._1)
      .map {
        case (date, records) =>
          (date, records.map(_._2).sum)
      }
      .toList
      .sortBy(_._1)
      .take(30)

    println("Daily Sales from Kaggle CSV:")

    dailySales.foreach {
      case (date, sales) =>
        println(s"$date : $sales")
    }

    val salesValues = dailySales.map(_._2)

    val totalSales = salesValues.sum
    val averageSales = totalSales.toDouble / salesValues.length
    val maximumSales = salesValues.max
    val minimumSales = salesValues.min

    println()
    println("Time Series Analysis:")
    println(s"Total Sales   : $totalSales")
    println(s"Average Sales : $averageSales")
    println(s"Maximum Sales : $maximumSales")
    println(s"Minimum Sales : $minimumSales")
  }
}