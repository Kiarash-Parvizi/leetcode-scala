import scala.math.max

object Solution {
    def longestPalindrome(s: String): String = {
        def getR(i: Int, even: Int, r: Int = 1): Int = {
            val (left, right) = (i-r + even, i+r)
            if (left < 0 || right >= s.length || s(left) != s(right)) return r-1
            getR(i, even, r+1)
        }
        var (maxS, maxRng) = (0,0)
        for (i <- 0 until s.length) {
            var r = getR(i, 0)
            var rng = r*2 + 1
            if (rng > maxRng) {
                maxRng = rng; maxS = i-r;
            }
            r = getR(i, 1)
            rng = r*2
            if (rng > maxRng) {
                maxRng = rng; maxS = i-r+1;
            }
        }
        return s.slice(maxS, maxS+maxRng)
    }
}

object Test extends App {
  val s: String = "babad"
  println("\ninput:")
  println(s)
  val res = Solution.longestPalindrome(s)
  println("\noutput:")
  println(res)
}
