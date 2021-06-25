import collection.mutable.{ListBuffer,ArrayBuffer}
import util.control.Breaks._

object Solution {
    def solveNQueens(n: Int): List[List[String]] = {
        val ls = ListBuffer[List[String]]()
        def validPermutations(): ListBuffer[List[Int]] = {
            val ls = ListBuffer[List[Int]]()
            // gen function
            def gen(id: Int, acc: List[Int]): Unit = {
                if (id >= n) { ls.append(acc); return; }
                for (col <- 0 until n) {
                    var ok = true
                    breakable {for (i <- 0 until id) {
                        if (math.abs(acc(i)-col) == i+1
                            || acc(i) == col) {
                            ok = false; break;
                        }
                    }}
                    if (ok) gen(id+1, col :: acc)
                }
            }
            gen(0, List[Int]()); ls
        }
        // convert to List[String]
        for (perm <- validPermutations()) {
            ls += List.range(0, n).map(perm(_)).map(i => "."*i + "Q" + "."*(n-1-i))
        }
        ls.toList
    }
}

object Test extends App {
  val n = 4
  println("\ninput:")
  println(n)
  val res: List[List[String]] = Solution.solveNQueens(n)
  println("\noutput:")
  println(res)
}
