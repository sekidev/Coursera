object LargestNumberImp {

  def largestNumber(digits: List[Int]): String = {

    def remove(l1: List[String], l2: List[String]) = l1 diff l2

    def isGreaterOrEqual(digit: String, maxDigit: String): Boolean = {
      //println(digit + "|" + maxDigit + ".compare(" + maxDigit + "|" + digit + ")")
      if ((digit + maxDigit).compare(maxDigit + digit) > 0) {
        //println("true")
        true
      }else{
        //println("false")
        false}
    }

    def chooseMax(leftDigits: List[String], maxDigit: String): String =
      leftDigits match {
        case Nil => maxDigit
        case x::xs => if (isGreaterOrEqual(x, maxDigit)) chooseMax(xs, x)
        else chooseMax(xs, maxDigit)
      }

    def iterDigits(leftDigits: List[String], answer: List[String]): String =
      leftDigits match {
        case Nil => answer.foldLeft ("") ((e1, e2) => e1 + e2)
        case x::xs => {
          val maxDigit = chooseMax(xs, x)
          val newList = if (maxDigit == x) {
            xs
          }
          else {
            remove(xs ++ List(x), List(maxDigit))
          }
          //val removed = remove(newList, List(maxDigit))
          //println("endMax: " + maxDigit)
          iterDigits(newList, answer ++ List(maxDigit))
        }
      }

    iterDigits(digits.map(_.toString).sortWith((e1, e2) => e1 > e2), Nil)
  }

  def main(args: Array[String]): Unit = {

    scala.io.StdIn.readLine()
    val input = scala.io.StdIn.readLine()
    val tokens = input.split(" ").map(_.toInt)

    println(largestNumber(tokens.toList))
  }
}