import scala.collection.mutable.Map

object Solution {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val mp = Map[Int, Int]()
    nums.zipWithIndex.foreach{case(num,id1) => {
      mp.get(target-num) match {
        case Some(id2) => return Array(id1, id2)
        case None => {}
      }
      mp += (num -> id1)
    }}
    Array(-1,-1)
  }
}

object Test extends App {
  val nums  : Array[Int] = Array(2,7,11,15)
  val target: Int = 9
  val res:Array[Int] = Solution.twoSum(nums, target)
  println(res.mkString(" "))
}
