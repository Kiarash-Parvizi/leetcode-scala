// Definition for a binary tree node.
class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

import scala.collection.mutable.ListBuffer
object Solution {
    def levelOrderBottom(root: TreeNode): List[List[Int]] = {
        val ls = ListBuffer[ListBuffer[Int]]()
        def SLR(node: TreeNode, level: Int = 0): Unit = {
            if (node == null) return
            if (level >= ls.length) ls.append(ListBuffer())
            ls(level).append(node.value)
            SLR(node.left, level+1)
            SLR(node.right, level+1)
        }; SLR(root)
        ls.map(x=>x.toList).reverse.toList
    }
}
