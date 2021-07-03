import collection.mutable.Map
// Trie
class Trie(elements: Array[String]) {
    // Node class
    class Node(val word: String, var wEnd: Boolean) {
        val chs = Map[Char, Node]()
        // getOrMake
        def getOrMake_ch(c: Char, isLast: Boolean): Node = {
            chs.get(c) match {
                case Some(nd) => {
                    if (isLast) nd.wEnd = true
                    nd
                }
                case None => {
                    val nd = new Node(word + c, isLast)
                    chs += (c -> nd)
                    nd
                }
            }
        }
        def get_ch(c: Char): Option[Node] = {
            chs.get(c)
        }
    }
    // 
    val baseNode = new Node("", false)
    // iter over elements to make the trie
    for (el <- elements) {
        var node = baseNode
        for (i <- 0 until el.length) {
            val c = el(i)
            node = (
                if(i == el.length-1) node.getOrMake_ch(c, true)
                else node.getOrMake_ch(c, false)
            )
        }
    }
}

import collection.mutable.{Stack}
object Solution {
    def findWords(board: Array[Array[Char]], words: Array[String]): List[String] = {
        val trie = new Trie(words)
        val resSt = collection.mutable.Set[String]()
        // board
        val memTable = collection.mutable.Set[(String,Int,Int)]()
        val (m, n) = (board.length, board(0).length)
        for (h <- 0 until m; w <- 0 until n) {
            val st = Stack[(Int,Int,Option[trie.Node],Set[(Int,Int)])](
                (h, w, trie.baseNode.get_ch(board(h)(w)),
                    Set[(Int,Int)]((h,w))
                )
            )
            // Run DFS
            while (st.length > 0) {
                val(i, j, nodeO, vised) = st.pop()
                nodeO match {
                    case Some(node) => {
                        // check memTable
                        if (!memTable.contains(node.word, i, j)) {
                            // add to memTable
                            memTable += ((node.word, i, j))
                            // check for wEnd
                            if (node.wEnd) {
                                resSt += node.word
                            }
                            // add childs
                            for (x <- -1 to 1; y <- -1 to 1)
                                if (x * y == 0 &&
                                    i+x < m && i+x >= 0 &&
                                    j+y < n && j+y >= 0 &&
                                    !vised.contains(i+x,j+y))
                                {
                                    st.push((
                                        i+x,j+y,node.get_ch(board(i+x)(j+y)),
                                        vised + ((i+x,j+y))
                                    ))
                                }
                        }
                    }
                    case None => {}
                }
            }
        }
        resSt.toList
    }
}


object Test extends App {
    val board = Array(
        Array('o','a','a','n'),
        Array('e','t','a','e'),
        Array('i','h','k','r'),
        Array('i','f','l','v')
    )
    val words = Array("oath","pea","eat","rain")
    println("\ninput:")
    println("Board:")
    println(board.map(_.mkString(" ")).mkString("\n"))
    println("\nWords:")
    println(words.mkString(" "))
    val res: List[String] = Solution.findWords(board, words)
    println("\noutput:")
    println(res)
}
