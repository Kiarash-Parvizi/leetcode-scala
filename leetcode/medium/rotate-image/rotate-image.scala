object Solution {
    def rotate(matrix: Array[Array[Int]]): Unit = {
        val n = matrix.length
        def R4(p0: (Int,Int)): Unit = {
            println(p0)
            val (p1,p2,p3) = (
                (p0._2,n-1-p0._1),(n-1-p0._1,n-1-p0._2),(n-1-p0._2,p0._1))
            val tmp = matrix(p3._1)(p3._2)
            matrix(p3._1)(p3._2) = matrix(p2._1)(p2._2)
            matrix(p2._1)(p2._2) = matrix(p1._1)(p1._2)
            matrix(p1._1)(p1._2) = matrix(p0._1)(p0._2)
            matrix(p0._1)(p0._2) = tmp
        }
        for (off <- 0 until n/2) {
            for (w <- off until n-1-off) {
                R4(off, w)
            }
        }
    }
}

object Test extends App {
  val matrix = Array[Array[Int]](
    Array(1,2,3),Array(4,5,6),Array(7,8,9))
  println("\ninput:")
  println(matrix.map(_.mkString(",")).mkString(" | "))
  Solution.rotate(matrix)
  println("\noutput:")
  println(matrix.map(_.mkString(",")).mkString(" | "))
}
