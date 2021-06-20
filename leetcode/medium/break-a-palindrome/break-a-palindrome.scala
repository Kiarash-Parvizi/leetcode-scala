
object Solution {
    def breakPalindrome(palindrome: String): String = {
        val N: Int = palindrome.length
        if (N <= 1) return ""
        def prim(i: Int) = N-1 - i
        def reduce(i: Int): String = {
            if (i >= N)
                palindrome.updated(N-1, 'b')
            else if (prim(i) != i && palindrome(i) != 'a') {
                palindrome.updated(i, 'a')
            } else reduce(i+1)
        }
        reduce(0)
    }
}

object Test extends App {
  val palindrome: String = "abccba"
  println("\ninput:")
  println(palindrome)
  val res = Solution.breakPalindrome(palindrome)
  println("\noutput:")
  println(res)
}
