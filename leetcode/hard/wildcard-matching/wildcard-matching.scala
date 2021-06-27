object Solution {
    def isMatch(s: String, p: String): Boolean = {
        if (s.length == 0) return (s == p || p.count(_=='*') == p.length)
        if (p.length == 0) return false
        // find subpattern in string s, starting from position i
        def find(p: String, i: Int, hasStar: Boolean): Int = {
            val rng = (
                if (hasStar) s.length-p.length
                else i
            )
            for (i <- i to rng) {
                var a = 0
                while (
                    a < p.length &&
                    (p(a) == '?' || s(i+a) == p(a))
                ) a += 1
                if (a == p.length) return i+a
            }
            return -1
        }
        var (i, patId, hasStar) = (0, 1, false)
        val patterns = p.split('*')
        val lastP = p(p.length-1)
        if (patterns.length == 0) return true
        for (pat <- patterns) {
            if (i > s.length-pat.length) return false
            if (lastP != '*' && hasStar && patId == patterns.length)
                i = s.length-pat.length
            // proc
            i = find(pat, i, hasStar)
            hasStar = (patId != patterns.length)
            if (i == -1) return false
            //
            patId += 1
        }
        if (lastP == '*') hasStar = true
        (i == s.length || hasStar)
    }
}

object Test extends App {
    val (s,p) = ("adceb", "*a??*?b")
    println("\ninput:")
    println(s, p)
    val res = Solution.isMatch(s, p)
    println("\noutput:")
    println(res)
}
