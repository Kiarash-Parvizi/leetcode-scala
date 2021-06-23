object Solution {
    def generateParenthesis(n: Int): List[String] = {
        def generator(n: Int): List[String] = {
            if (n == 1) return List("()")
            if (n == 0) return List("")
            var res = List[String]()
            for (i <- 0 until n) {
                res = generator(i).flatMap(x => generator(n-1-i).map(y => (x, y)))
                .map{case(a,b) => f"($a)$b"} ::: res
            }
            res
        }
        generator(n)
    }
}

object Test extends App {
  val n: Int = 3
  println("\ninput:")
  println(n)
  val res = Solution.generateParenthesis(n)
  println("\noutput:")
  println(res)
}
