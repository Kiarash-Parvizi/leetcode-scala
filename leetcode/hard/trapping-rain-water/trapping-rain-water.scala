import collection.mutable.ArrayBuffer

object Solution {
    def trap(height: Array[Int]): Int = {
        if (height.length == 0) return 0
        // get next
        def next(i0: Int): Int = {
            var (mx,mx_i) = (0,i0)
            for (i <- i0+1 until height.length) {
                if (height(i) >= height(i0)) return i
                else if (height(i) >= mx) {
                    mx = height(i); mx_i = i;
                }
            }
            return mx_i
        }
        // create depth-map
        val depth = ArrayBuffer.fill(height.length)(-1)
        var (i, inext) = (0,0)
        do {
            i = inext; inext = next(i)
            depth(i) = math.min(height(i), height(inext))
        } while (i != inext);
        // final iteration
        var (dep,res) = (-1,0)
        for (i <- 0 until height.length) {
            if (depth(i) != -1) dep = depth(i)
            if (height(i) < dep) {
                res += dep-height(i)
            }
        }
        res
    }
}

object Test extends App {
  val height = Array[Int](0,1,0,2,1,0,1,3,2,1,2,1)
  println("\ninput:")
  println(height.mkString(" "))
  val res: Int = Solution.trap(height)
  println("\noutput:")
  println(res)
}
