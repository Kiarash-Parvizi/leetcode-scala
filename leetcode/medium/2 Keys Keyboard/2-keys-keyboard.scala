import scala.annotation.tailrec

object Solution {
    def minSteps(n: Int): Int = {
      if (n == 1) return 0;
      @tailrec
      def getSum_PrimeFactors(n: Int, acc: Int = 0, i: Int = 2)
      : Int = i*i <= n match {
          case true if n % i == 0 => getSum_PrimeFactors(n/i, i+acc, i)
          case true => getSum_PrimeFactors(n, acc, i+1)
          case false => acc + n
        }
      getSum_PrimeFactors(n)
    }
}

object Test extends App {
  val n: Int = 20
  println("\ninput:")
  println(n)
  val res: Int = Solution.minSteps(n)
  println("\noutput:")
  println(res)
}
