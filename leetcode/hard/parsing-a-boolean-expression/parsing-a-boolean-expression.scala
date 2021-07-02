import collection.mutable.ListBuffer
object Solution {
    class Parser(expr: String) {
        // split
        private def split(expr: String): List[String] = {
            var (i, curlyCnt) = (0, 0)
            val ls = ListBuffer[String]()
            for (j <- 1 until expr.length) expr(j) match {
                case '(' => curlyCnt += 1
                case ')' => curlyCnt -= 1
                case ',' => if (curlyCnt == 0) {
                    ls += expr.slice(i, j)
                    i = j+1
                }
                case _ => {}
            }
            if (i != expr.length) ls += expr.slice(i, expr.length)
            ls.toList
        }
        // logic functions
        private def not(expr: String): Char = {
            if (eval(expr) == 't') 'f' else 't'
        }
        private def or(expr: String): Char = {
            for (v <- split(expr))
                if (eval(v) == 't') return 't'
            'f'
        }
        private def and(expr: String): Char = {
            for (v <- split(expr))
                if (eval(v) == 'f') return 'f'
            't'
        }
        // evaluate expression
        private def eval(expr: String): Char = {
            expr(0) match {
                case '!' => not(expr.slice(2, expr.length-1))
                case '|' =>  or(expr.slice(2, expr.length-1))
                case '&' => and(expr.slice(2, expr.length-1))
                case v => v
            }
        }
        def run(): Boolean = {
            if (eval(expr) == 't') true else false
        }
    }
    def parseBoolExpr(expression: String): Boolean = {
        new Parser(expression).run()
    }
}

object Test extends App {
    val expr = "|(&(t,f,t),!(t))"
    println("\ninput:")
    println(expr)
    val res = Solution.parseBoolExpr(expr)
    println("\noutput:")
    println(res)
}
