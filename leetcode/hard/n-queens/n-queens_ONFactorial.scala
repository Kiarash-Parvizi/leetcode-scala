// O(n!) solution without backtracking
object Solution {
    def solveNQueens(n: Int): List[List[String]] = {
        val ls = collection.mutable.ListBuffer[List[String]]()
        for (perm <- List.range(0, n).permutations) {
            def check(): Boolean = {
                for (i <- 0   until n)
                for (j <- i+1 until n)
                    if (math.abs(perm(i)-perm(j)) == j-i) { return false; }
                return true;
            }
            if (check()) {
                ls += List.range(0, n).map(perm(_)).map(i => "."*i + "Q" + "."*(n-1-i))
            }
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
