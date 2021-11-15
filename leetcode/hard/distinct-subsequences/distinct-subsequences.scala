object Solution {
    def numDistinct(s: String, t: String): Int = {
        val (n, m) = (s.length, t.length)
        var dp = new Array[Int](m+1)
        dp(0) = 1
        for (i <- 0 until n) {
            for (j <- m-1 to 0 by -1) {
                if (s(i) == t(j)) {
                    dp(j+1) += dp(j)
                }
            }
        }
        dp(m)
    }
}

object Test extends App {
    val (s, t) = ("rabbbit", "rabbit")
    println("\ninput:")
    println((s, t))
    val res: Int = Solution.numDistinct(s,t)
    println("\noutput:")
    println(res)
}