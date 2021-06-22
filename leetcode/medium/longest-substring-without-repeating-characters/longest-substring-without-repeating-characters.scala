import scala.collection.mutable.Map

object Solution {
    def lengthOfLongestSubstring(s: String): Int = {
        if (s.length == 0) return 0
        // initialize
        val dp = Array.fill[(Int,Int)](s.length)(0,0)
        val LastPos = Map[Char,Int]()
        LastPos.update(s(0),0)
        dp(0) = (1,0)
        // process
        for (i <- 1 until s.length) {
            LastPos.get(s(i)) match {
                case Some(lp) =>
                    if (lp >= dp(i-1)._2) dp(i) = (i-lp, lp+1)
                    else dp(i) = (dp(i-1)._1 + 1, dp(i-1)._2)
                case None => {
                    dp(i) = (dp(i-1)._1 + 1, dp(i-1)._2)
                }
            }
            LastPos(s(i)) = i
        }
        dp.max._1
    }
}

object Test extends App {
  val s: String = "abcabcbb"
  println("\ninput:")
  println(s)
  val res = Solution.lengthOfLongestSubstring(s)
  println("\noutput:")
  println(res)
}
