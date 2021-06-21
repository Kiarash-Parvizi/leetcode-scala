import scala.collection.mutable.ArrayBuffer
import scala.math.max

object Solution {
    def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
        // sort intervals based on start position
        val sorted = intervals.sortWith(_(0) < _(0))
        val buf = ArrayBuffer[Array[Int]](sorted(0))
        // MergeInterval with index=idx
        def MergeInterval(idx: Int): Unit = {
            if (idx >= sorted.length) return
            val (int, top) = (sorted(idx), buf(buf.length-1))
            if (int(0) <= top(1)) top(1) = max(top(1), int(1))
            else buf.append(int)
            MergeInterval(idx+1)
        };
        MergeInterval(1)
        buf.toArray
    }
}


object Test extends App {
  val intervals = Array[Array[Int]](
    Array(1,3),Array(2,6),Array(8,10),Array(15,18))
  println("\ninput:")
  println(intervals.map(_.mkString(",")).mkString(" "))
  val res = Solution.merge(intervals)
  println("\noutput:")
  println(res.map(_.mkString(",")).mkString(" "))
}
