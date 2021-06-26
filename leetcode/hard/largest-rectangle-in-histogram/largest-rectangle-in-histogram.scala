import collection.mutable.Stack
import math.{min,max}
object Solution {
    def largestRectangleArea(heights: Array[Int]): Int = {
        val st = Stack[(Int,Int)]()
        var (mx,n) = (0,heights.length)
        for (i <- 0 until n) {
            while (!st.isEmpty && heights(st.top._1) >= heights(i)) {
                val top = st.pop()
                if (heights(top._1) != heights(i))
                    mx = max(mx, (i-top._1-1)*heights(top._1) + top._2)
            }
            var backV = 0
            if (st.isEmpty) {
                backV = (i+1)*heights(i)
                mx = max(mx, backV)
            } else {
                backV = (i-st.top._1)*heights(i)
                mx = max(mx, backV)
            }
            st.push((i,backV))
        }
        while (!st.isEmpty) {
            val top = st.pop()
            mx = max(mx, (n-top._1-1)*heights(top._1) + top._2)
        }
        mx
    }
}

object Test extends App {
  val heights = Array[Int](2,1,5,6,2,3)
  println("\ninput:")
  println(heights.mkString(" "))
  val res: Int = Solution.largestRectangleArea(heights)
  println("\noutput:")
  println(res)
}
