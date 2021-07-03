object Solution {
    def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
        val n = gas.length
        val arr = for(i <- 0 until n) yield gas(i)-cost(i)
        var (s, e, i, sum) = (n, 0, 0, 0)
        while (s > e) {
            sum += arr(i)
            if (sum >= 0) {
                e += 1; i = e;
            } else {
                s -= 1; i = s;
            }
        }
        if (sum >= 0)
            s % n
        else -1
    }
}

object Test extends App {
  val (gas, cost) = (
    Array(1,2,3,4,5),
    Array(3,4,5,1,2)
  )
  println("\ninput:")
  println(gas.mkString(" "))
  println(cost.mkString(" "))
  val res = Solution.canCompleteCircuit(gas, cost)
  println("\noutput:")
  println(res)
}

