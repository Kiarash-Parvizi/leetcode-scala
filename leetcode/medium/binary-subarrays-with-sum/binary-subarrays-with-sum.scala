import scala.collection.mutable.ArrayBuffer

object Solution {
    def numSubarraysWithSum(nums: Array[Int], goal: Int): Int = {
      val buf = ArrayBuffer[Int](0)
      // iter over nums
      for (i <- 0 to nums.length-1)
        if (nums(i) == 1) buf += 0
        else buf(buf.length-1) += 1
      // iter over buf
      var res: Int = 0
      if (goal == 0) {
        for (i <- 0 to buf.length-1)
          res += buf(i) + buf(i)*(buf(i)-1)/2
      } else {
        for (i <- goal to buf.length-1)
          res += (buf(i)+1) * (buf(i-goal)+1)
      }
      return res
    }
}

object Test extends App {
  val nums = Array(1,0,1,0,1)
  val goal: Int = 2
  println("\ninput:")
  println(nums.mkString(" "))
  println(goal)
  val res: Int = Solution.numSubarraysWithSum(nums, goal)
  println("\noutput:")
  println(res)
}
