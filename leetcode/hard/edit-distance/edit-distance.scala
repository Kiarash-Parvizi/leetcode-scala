object Solution {
    def minDistance(word1: String, word2: String): Int = {
        val (m, n) = (word1.length, word2.length)
        if (m == 0) return n
        if (n == 0) return m
        // init dp
        val dp = Array.ofDim[Int](n, m+1)
        for (h <- 0 until n) dp(h)(m) = n-h
        for (w <- m-1 to 0 by -1) {
            if (word1(w) == word2(n-1))
                dp(n-1)(w) = m-w-1
            else
                dp(n-1)(w) = m-w min (dp(n-1)(w+1) + 1)
        }
        // fill dp
        for (i <- n-2 to 0 by -1; j <- m-1 to 0 by -1) {
            if (word1(j) == word2(i)) {
                dp(i)(j) = dp(i+1)(j+1)
            } else {
                val (v1, v2, v3) = (
                    dp(i+1)(j+1),
                    dp(i)(j+1),
                    dp(i+1)(j),
                )
                dp(i)(j) = (v1 min v2 min v3) + 1
            }
        }
        // return
        dp(0)(0)
    }
}

object Test extends App {
    val (word1, word2) = ("horse", "ros")
    println("\ninput:")
    println(word1, word2)
    val res: Int = Solution.minDistance(word1, word2)
    println("\noutput:")
    println(res)
}
