object Solution {
    def maximalSquare(matrix: Array[Array[Char]]): Int = {
        val (m, n) = (matrix.length, matrix(0).length)
        val hDp = Array.ofDim[Int](m, n)
        val wDp = Array.ofDim[Int](m, n)
        val rDp = Array.ofDim[Int](m, n)
        // fill wDp
        for (h <- 0 until m) {
            var sum = 0
            for (w <- 0 until n) {
                matrix(h)(w) match {
                    case '1' => sum += 1
                    case _   => sum  = 0
                }
                wDp(h)(w) = sum
            }
        }
        // fill hDp
        for (w <- 0 until n) {
            var sum = 0
            for (h <- 0 until m) {
                matrix(h)(w) match {
                    case '1' => sum += 1
                    case _   => sum  = 0
                }
                hDp(h)(w) = sum
            }
        }
        // fill rDp
        var mx = 0
        for (h <- 0 until m) {
            for (w <- 0 until n) matrix(h)(w) match {
                case '0' => rDp(h)(w) = 0
                case _   => {
                    val r = (
                        if (w == 0 || h == 0) 1
                        else rDp(h-1)(w-1) + 1
                    )
                    rDp(h)(w) = wDp(h)(w) min hDp(h)(w) min r
                    mx = mx max rDp(h)(w)
                }
            }
        }
        mx*mx
    }
}

object Test extends App {
    val matrix = Array[Array[Char]](
        Array('1','0','1','0','0'),
        Array('1','0','1','1','1'),
        Array('1','1','1','1','1'),
        Array('1','0','0','1','0')
    )
    println("\ninput:")
    println(matrix.map(_.mkString(" ")).mkString("\n"))
    var res = Solution.maximalSquare(matrix)
    println("\noutput:")
    println(res)
}
