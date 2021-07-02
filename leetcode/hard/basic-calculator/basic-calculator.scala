import collection.mutable.Stack
object Solution {
    def calculate(s: String): Int = {
        var mul = 1
        val mulSt = Stack[Int](1)
        var res: Int = 0
        var i = 0
        while (i < s.length) {
            s(i) match {
                case ' ' | '+' => 
                case '-' => mul = -1
                case '(' => {
                    mulSt.push(mulSt.top*mul)
                    mul = 1
                }
                case ')' => {
                    mulSt.pop()
                    mul = 1
                }
                case _ => {
                    var tmpR = s(i)-'0'
                    while (i+1 < s.length && Character.isDigit(s(i+1))) {
                        tmpR = 10*tmpR + s(i+1)-'0'
                        i += 1
                    }
                    res += mul * mulSt.top * tmpR
                    mul = 1
                }
            }
            i += 1
        }
        res
    }
}


object Test extends App {
    val s = "(1+(4+5+2)-3)+(6+8)"
    println("\ninput:")
    println(s)
    val res = Solution.calculate(s)
    println("\noutput:")
    println(res)
}
