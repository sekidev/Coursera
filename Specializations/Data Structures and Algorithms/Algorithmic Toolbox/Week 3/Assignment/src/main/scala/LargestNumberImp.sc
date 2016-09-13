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
      case Nil => answer.foldLeft ("") ((e1, e2) => e1 + "," + e2)
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

//List(9, 2, 200, 100, 110, 8, 1, 1, 232).map(_.toString).sorted
List(9, 2, 200, 100, 110, 8, 1, 1).map(_.toString).sortWith((e1, e2) => e1 > e2)
List(2, 8, 2, 3, 6, 4, 1, 1, 10, 6, 3, 3, 6, 1, 3, 8, 4, 6, 1, 10, 8, 4, 10, 4, 1, 3, 2, 3, 2, 6, 1, 5, 2, 9, 8, 5, 10, 8, 7, 9, 6, 4, 2, 6, 3, 8, 8, 9, 8, 2, 9, 10, 3, 10, 7, 5, 7, 1, 7, 5, 1, 4, 7, 6, 1, 10, 5, 4, 8, 4, 2, 7, 8, 1, 1, 7, 4, 1, 1, 9, 8, 6, 5, 9, 9, 3, 7, 6, 3, 10, 8, 10, 7, 2, 5, 1, 1, 9, 9, 5).map(_.toString).sortWith((e1, e2) => e1 > e2)
largestNumber(List(2, 21))
largestNumber(List(9, 4, 6, 1, 9))
largestNumber(List(23, 39, 92))
largestNumber(List(9, 2, 200, 100, 110, 8, 1, 1))
largestNumber(List(2, 8, 2, 3, 6, 4, 1, 1, 10, 6, 3, 3, 6, 1, 3, 8, 4, 6, 1, 10, 8, 4, 10, 4, 1, 3, 2, 3, 2, 6, 1, 5, 2, 9, 8, 5, 10, 8, 7, 9, 6, 4, 2, 6, 3, 8, 8, 9, 8, 2, 9, 10, 3, 10, 7, 5, 7, 1, 7, 5, 1, 4, 7, 6, 1, 10, 5, 4, 8, 4, 2, 7, 8, 1, 1, 7, 4, 1, 1, 9, 8, 6, 5, 9, 9, 3, 7, 6, 3, 10, 8, 10, 7, 2, 5, 1, 1, 9, 9, 5))