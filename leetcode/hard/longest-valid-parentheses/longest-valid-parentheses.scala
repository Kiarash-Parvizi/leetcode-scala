import collection.mutable.HashMap
object Solution {
    def longestValidParentheses(s: String): Int = {
        val firstLoc = HashMap[Int,Int]()
        var (h,mx,lh,goingDown) = (0,0,1e9.toInt,false)
        for (i <- 0 until s.length) {
            val c = s(i)
            if (c == '(') {
                h += 1
                if (h >= lh) {
                    if (!goingDown)
                        firstLoc(h) = i
                } else {
                    firstLoc(h) = i
                    lh = h
                }
                goingDown = false
            }
            else {
                firstLoc.get(h) match {
                    case Some(s) => mx = math.max(mx, i-s+1)
                    case None    => {}
                }
                h -= 1
                goingDown = true
            }
        }
        mx
    }
}

object Test extends App {
    val s: String = ")()())"
    println("\ninput:")
    println(s)
    val res: Int = Solution.longestValidParentheses(s)
    println("\noutput:")
    println(res)
}
