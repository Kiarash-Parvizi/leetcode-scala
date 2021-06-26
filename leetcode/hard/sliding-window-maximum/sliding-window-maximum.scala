import collection.mutable.SortedMap

object Solution {
    def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
        // initialize SortedMap with reverse ordering
        implicit val Ord = implicitly[Ordering[Int]]
        val mp = SortedMap.empty[Int, Int](Ord.reverse)
        // map util functions
        def add(key: Int): Unit = {
            mp.get(key) match {
                case Some(v) => mp.update(key,v+1)
                case None => mp += (key -> 1)
            }
        }
        def rem(key: Int): Unit = {
            mp(key) match {
                case 1 => mp.remove(key)
                case v => mp.update(key,v-1)
            }
        }
        // init
        val res = Array.fill[Int](nums.length-k+1)(-1)
        for (i <- 0 until k) add(nums(i))
        res(0) = mp.head._1
        // calc
        for (i <- k until nums.length) {
            add(nums(i)); rem(nums(i-k));
            // set max
            res(i-k+1) = mp.head._1
        }
        res
    }
}

object Test extends App {
  val nums = Array[Int](1,3,-1,-3,5,3,6,7)
  val k = 3
  println("\ninput:")
  println(nums.mkString(" "))
  val res = Solution.maxSlidingWindow(nums, k)
  println("\noutput:")
  println(res.mkString(" "))
}
