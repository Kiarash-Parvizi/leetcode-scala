import collection.mutable.{HashMap,HashSet,ListBuffer,Queue}
object Solution {
    def ladderLength(beginWord: String, endWord: String, wordList: List[String]): Int = {
        if (beginWord.length == 1)
            if (wordList.contains(endWord)) 1 else 0
        // generate required HashMaps
        val (sub2w, w2sub) = (HashMap[String,ListBuffer[(String,Int)]](),
                              HashMap[String,ListBuffer[String]]())
        for(str <- beginWord :: wordList) {
            if (!w2sub.contains(str)) {
                val subBuf = ListBuffer[String]()
                for (i <- 0 until str.length) {
                    val sub = str.patch(i, Nil, 1)
                    subBuf += sub
                    sub2w.get(sub) match {
                        case Some(ls) => ls.append((str,i))
                        case None => sub2w(sub) = ListBuffer((str,i))
                    }
                }
                w2sub(str) = subBuf
            }
        }
        // getAdj: returns the adjacent strings
        def getAdj(str: String): ListBuffer[String] = {
            var ls = ListBuffer[String]()
            var i = 0
            for (sub <- w2sub(str)) {
                for (nStr <- sub2w(sub))
                    if (nStr._2 == i)
                        ls += nStr._1
                i += 1
            }
            ls
        }
        // run bfs
        val qu      = Queue[String](beginWord)
        val stageQu = Queue[Int](0)
        val vised = HashSet[String](beginWord)
        while(qu.length > 0) {
            val (top, stage) = (qu.dequeue, stageQu.dequeue)
            if (top == endWord) return stage + 1
            for (adj <- getAdj(top)) {
                if (!vised.contains(adj)) {
                    qu.enqueue(adj)
                    stageQu.enqueue(stage+1)
                    vised += adj
                }
            }
        }
        0
    }
}

object Test extends App {
    val beginWord = "hit"
    val endWord = "cog"
    val wordList = List("hot","dot","dog","lot","log","cog")
    println("\ninput:")
    println(beginWord, endWord)
    println(wordList)
    val res: Int = Solution.ladderLength(beginWord,endWord,wordList)
    println("\noutput:")
    println(res)
}
