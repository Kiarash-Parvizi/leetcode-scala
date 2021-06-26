import collection.mutable.{ListBuffer,StringBuilder}

object Solution {
    def fullJustify(words: Array[String], maxWidth: Int): List[String] = {
        def f(i: Int, acc: Int): (Int,Int) = {
            if (i >= words.length) return (i, maxWidth - acc)
            val newW = words(i).length + acc + 1
            if (newW <= maxWidth) {
                f(i+1, newW)
            } else {
                return (i, maxWidth - acc)
            }
        }
        val buf = ListBuffer[String]()
        var i = 0
        while (i < words.length) {
            val (j,extra) = f(i, -1)
            // fullJustify
            def fullJustify(): String = {
                var (spaceCnt,firstCnt) = 
                    (1+extra/(j-i-1), extra%(j-i-1))
                // write text
                val str = new StringBuilder("")
                while (i < j) {
                    val spaces = spaceCnt + (
                        if (firstCnt > 0) { firstCnt-=1; 1 }
                        else 0
                    )
                    // append string
                    str ++= words(i) + (
                        if (j-i > 1) " "*spaces
                        else ""
                    )
                    i += 1
                }
                str.toString
            }
            // leftJustify
            def leftJustify(): String = {
                val str = new StringBuilder("")
                while (i < j) {
                    // append string
                    str ++= words(i) + (
                        if (j-i > 1) " "
                        else " "*extra
                    )
                    i += 1
                }
                str.toString
            }
            if (j-i == 1 || j == words.length)
                buf += leftJustify()
            else buf += fullJustify()
        }
        buf.toList
    }
}

object Test extends App {
  val words = Array[String](
    "This", "is", "an", "example", "of", "text", "justification."
  )
  val maxWidth = 16
  println("\ninput:")
  println(words.mkString(" "))
  println(maxWidth)
  val res = Solution.fullJustify(words, maxWidth)
  println("\noutput:")
  println(res.mkString("\n"))
}
