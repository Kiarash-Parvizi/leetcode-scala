object Solution {
    def canJump(nums: Array[Int]): Boolean = {
        val n  = nums.length
        val dp = Array.fill[Boolean](n)(false)
        dp(n-1) = true
        var nextValidPoint = n-1
        for (i <- n-2 to 0 by -1) {
            val jump = nums(i)
            if (i+jump >= nextValidPoint) {
                dp(i) = true
                nextValidPoint = i
            }
        }
        dp(0)
    }
}

object Test extends App {
    val nums = Array[Int](3,2,1,0,4)
    println("\ninput:")
    println(nums.mkString(" "))
    val res = Solution.canJump(nums)
    println("\noutput:")
    println(res)
}
