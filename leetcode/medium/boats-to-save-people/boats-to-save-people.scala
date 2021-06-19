import scala.annotation.tailrec

object Solution {
    def numRescueBoats(people: Array[Int], limit: Int): Int = {
      scala.util.Sorting.quickSort(people)
      @tailrec
      def f(hb: Int, lb: Int, acc: Int): Int = {
        if (hb <= lb) return acc
        people(hb) + people(lb+1) <= limit match {
          case true  => f(hb-1, lb+1, acc+1)
          case false => f(hb-1, lb  , acc+1)
        }
      }
      f(people.length-1, -1, 0)
    }
}

object Test extends App {
  val limit : Int = 5
  val people = Array[Int](3, 5, 3, 4)
  println("\ninput:")
  println(people.mkString(" "))
  println(limit)
  val res: Int = Solution.numRescueBoats(people, limit)
  println("\noutput:")
  println(res)
}
