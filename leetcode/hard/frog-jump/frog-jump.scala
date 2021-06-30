import collection.mutable.{Stack,HashSet}
object Solution {
    def canCross(stones: Array[Int]): Boolean = {
        val n = stones.length
        if (stones(1)-stones(0) != 1) return false
        val st = Stack[(Int,Int)]((1,1))
        val vised = HashSet[(Int,Int)]()
        while (st.length > 0) {
            val top = st.pop()
            val (idx, k) = top
            if (idx == n-1) return true
            if (!vised.contains(top)) {
                vised += top
                var i = idx+1
                while (i < n && stones(i) < stones(idx)+k-1) i += 1
                if (i < n && stones(i) == stones(idx)+k-1) {
                    st.push((i, k-1))
                    i += 1
                    if (i < n && stones(i) == stones(idx)+k) {
                        st.push((i, k))
                        i += 1
                        if (i < n && stones(i) == stones(idx)+k+1) {
                            st.push((i, k+1))
                        }
                    } else if (i < n && stones(i) == stones(idx)+k+1) {
                        st.push((i, k+1))
                    }
                } else if (i < n && stones(i) == stones(idx)+k) {
                    st.push((i, k))
                    i += 1
                    if (i < n && stones(i) == stones(idx)+k+1) {
                        st.push((i, k+1))
                    }
                } else if (i < n && stones(i) == stones(idx)+k+1) {
                    st.push((i, k+1))
                }
            }
        }
        false
    }
}

object Test extends App {
    val stones = Array(0,1,3,5,6,8,12,17)
    println("\ninput:")
    println(stones.mkString(" "))
    val res = Solution.canCross(stones)
    println("\noutput:")
    println(res)
}
