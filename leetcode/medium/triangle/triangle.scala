object Solution {
    def minimumTotal(triangle: List[List[Int]]): Int = {
        val dp = triangle(triangle.length-1).toArray
        for (r <- dp.length-2 to 0 by -1) {
            var v0  = dp(0)
            val tri = triangle(r).toArray
            for (i <- 0 to r) {
                val tmp = dp(i+1)
                dp(i) = tri(i) + math.min(v0, dp(i+1))
                v0 = tmp
            }
        }
        dp(0)
    }
}

object Test extends App {
  val triangle = List[List[Int]](
    List(2),List(3,4),List(6,5,7),List(4,1,8,3))
  println("\ninput:")
  println(triangle.mkString("\n"))
  var res = Solution.minimumTotal(triangle)
  println("\noutput:")
  println(res)
}
