object Solution {
    def isValidSudoku(board: Array[Array[Char]]): Boolean = {
        class Point(val h: Int, val w: Int) {}
        def isValidBox(p0: Point, p1: Point): Boolean = {
            val mp = Array.fill[Boolean](10)(false)
            for (h <- p0.h to p1.h)
            for (w <- p0.w to p1.w)
                if (board(h)(w) != '.')
                if (mp(board(h)(w)-'0') == true)
                    return false
                else mp(board(h)(w)-'0') = true
            true
        }
        for (h <- 0 until 9 by 3)
        for (w <- 0 until 9 by 3)
            if(!isValidBox(new Point(h,w), new Point(h+2, w+2))) return false
        for (h <- 0 until 9)
            if(!isValidBox(new Point(h,0), new Point(h, 8))) return false
        for (w <- 0 until 9)
            if(!isValidBox(new Point(0,w), new Point(8, w))) return false
        return true
    }
}

object Test extends App {
    val board = Array[Array[Char]](
        Array('5','3','.','.','7','.','.','.','.'),
        Array('6','.','.','1','9','5','.','.','.'),
        Array('.','9','8','.','.','.','.','6','.'),
        Array('8','.','.','.','6','.','.','.','3'),
        Array('4','.','.','8','.','3','.','.','1'),
        Array('7','.','.','.','2','.','.','.','6'),
        Array('.','6','.','.','.','.','2','8','.'),
        Array('.','.','.','4','1','9','.','.','5'),
        Array('.','.','.','.','8','.','.','7','9')
    )
    println("\ninput:")
    println(board.map(_.mkString(" ")).mkString("\n"))
    var res = Solution.isValidSudoku(board)
    println("\noutput:")
    println(res)
}
