object Solution {
    def uniquePaths(m: Int, n: Int): Int = {
        def C(n: Int, k: Int): Long =
            if (k == 0 || k == n) 1
            else {
                val r = scala.math.min(k, n-k)
                var res: Long = 1
                for (i <- 1 to r) {
                    res *= (n+1-i); res /= i
                }
                res
            }
        C(n+m-2, n-1).toInt
    }
}

object Test extends App {
  val (m,n) = (3,7)
  println("\ninput:")
  println(m, n)
  val res = Solution.uniquePaths(m,n)
  println("\noutput:")
  println(res)
}
