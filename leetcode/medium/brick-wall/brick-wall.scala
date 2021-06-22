import scala.collection.mutable.Map

object Solution {
    def leastBricks(wall: List[List[Int]]): Int = {
        var mp = Map[Int,Int]()
        wall.foreach(row => {
            var pos: Int = 0
            row.dropRight(1).foreach(brick => {
                pos += brick
                mp.get(pos) match {
                    case Some(v) => mp.update(pos, v+1)
                    case None => { mp(pos) = 1 }
                }
            })
        })
        wall.length - (mp.size match {
            case 0 => 0
            case _ => mp.maxBy(_._2)._2
        })
    }
}

object Test extends App {
  val wall = List[List[Int]](
    List(1),List(1),List(1))
  println("\ninput:")
  println(wall)
  val res = Solution.leastBricks(wall)
  println("\noutput:")
  println(res)
}
