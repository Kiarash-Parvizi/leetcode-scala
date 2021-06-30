object Solution {
    def candy(ratings: Array[Int]): Int = {
        val n  = ratings.length
        val ls = Array.fill[Int](n)(1)
        var acc = 1
        for(i <- 1 until n) {
            if (ratings(i) > ratings(i-1)) {
                acc += 1
                ls(i) = acc
            } else if (ratings(i) == ratings(i-1)) {
                acc = 1
                ls(i) = acc
            }
            else acc = 1
        }
        acc = 1
        for (i <- n-2 to 0 by -1) {
            if (ratings(i) > ratings(i+1)) {
                acc += 1
                ls(i) = ls(i) max acc
            } else if (ratings(i) == ratings(i+1)) {
                acc = 1
                ls(i) = ls(i) max acc
            }
            else acc = 1
        }
        ls.reduceLeft(_ + _)
    }
}

object Test extends App {
    val ratings = Array(1, 0, 2)
    println("\ninput:")
    println(ratings.mkString(" "))
    val res: Int = Solution.candy(ratings)
    println("\noutput:")
    println(res)
}
