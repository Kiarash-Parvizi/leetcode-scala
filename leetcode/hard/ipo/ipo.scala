import collection.mutable.PriorityQueue

object Solution {
    def findMaximizedCapital(k: Int, w: Int, profits: Array[Int], capital: Array[Int]): Int = {
        val arr = (capital zip profits).sortWith(_._1 < _._1)
        val pq  = PriorityQueue[Int]()
        // addToPQueue
        def addToPQueue(idx: Int, maxCap: Int): Int = {
            if (idx >= arr.length || arr(idx)._1 > maxCap) return idx
            pq += arr(idx)._2
            addToPQueue(idx+1, maxCap)
        }
        var cap: Int = w
        var cnt: Int = 0
        var stopIdx: Int = addToPQueue(0, cap)
        while (cnt < k && pq.length > 0) {
            cap += pq.dequeue()
            cnt += 1
            stopIdx = addToPQueue(stopIdx, cap)
        }
        cap
    }
}


object Test extends App {
  val (k, w) = (2, 0)
  val profits = Array[Int](1,2,3)
  val capital = Array[Int](0,1,1)
  println("\ninput:")
  println(k, w)
  println(profits.mkString(" "))
  println(capital.mkString(" "))
  val res: Int = Solution.findMaximizedCapital(k, w, profits, capital)
  println("\noutput:")
  println(res)
}
