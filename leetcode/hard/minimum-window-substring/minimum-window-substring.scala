import collection.mutable.HashMap
import scala.annotation.tailrec
object Solution {
    def minWindow(s: String, t: String): String = {
        // each char is mapped to its count
        val tMp = HashMap[Char,Int]()
        t.foreach(c => {
            tMp.get(c) match {
                case Some(v) => tMp.update(c, v+1)
                case None    => tMp += (c -> 1)
            }
        })
        var completedCnt = 0
        // check if the given character is in the needed list
        def isNeededChar(c: Char): Boolean =
            tMp.contains(c)
        // check if move::mp contains all needed elements
        def containsAll(): Boolean =
            completedCnt == tMp.size
        // -----------------------
        var (mn,mn_i) = (1e9.toInt, -1)
        // move: recursive function
        @tailrec
        def move(
            mp: HashMap[Char,Int], left: Int, right: Int
        ): Unit = {
            if (right > s.length) return
            if (containsAll()) {
                // set min
                if (right - left < mn) {
                    mn = right - left; mn_i = left 
                }
                // change map
                val leftChar = s(left)
                if (isNeededChar(leftChar)) {
                    val v = mp(leftChar)
                    if (v == tMp(leftChar)) {
                        completedCnt -= 1
                    }
                    mp.update(leftChar, v-1)
                }
                // recur
                move(mp, left+1, right)
            } else {
                if (right == s.length) return
                val newChar = s(right)
                // change map
                if (isNeededChar(newChar))
                    mp.get(newChar) match {
                        case Some(v) => {
                            mp.update(newChar, v+1)
                            if (v+1 == tMp(newChar))
                                completedCnt += 1
                        }
                        case None    => {
                            mp(newChar)  = 1
                            if (1 == tMp(newChar))
                                completedCnt += 1
                        }
                    }
                // recur
                move(mp, left, right+1)
            }
        }
        move(HashMap[Char,Int](), 0,0)
        if (mn_i == -1) "" else
        s.slice(mn_i, mn_i+mn)
    }
}


object Test extends App {
    val (s,t) = ("ADOBECODEBANC", "ABC")
    println("\ninput:")
    println(s, t)
    val res = Solution.minWindow(s, t)
    println("\noutput:")
    println(res)
}
