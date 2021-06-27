import collection.mutable.ListBuffer
object Solution {
    def letterCombinations(digits: String): List[String] = {
        if (digits.length == 0) return List()
        val buf = ListBuffer[String]()
        def f(i: Int, acc: String): Unit = {
            if (i >= digits.length) buf += acc
            else {
                val dig = digits(i)-'0'
                val rng = (
                    if (dig == 7 || dig == 9) 4
                    else 3
                )
                val addI = (
                    if (dig > 7) 1
                    else 0
                )
                for (off <- 0 until rng)
                    f(i+1, acc+(97+3*(dig-2)+off+addI).toChar)
            }
        }
        f(0,"")
        buf.toList
    }
}

object Test extends App {
    val s: String = "23"
    println("\ninput:")
    println(s)
    val res = Solution.letterCombinations(s)
    println("\noutput:")
    println(res)
}
