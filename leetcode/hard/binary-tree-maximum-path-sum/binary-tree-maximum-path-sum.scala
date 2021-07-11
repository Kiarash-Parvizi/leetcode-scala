// Definition for a binary tree node.
class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
}

object Solution {
    def maxPathSum(root: TreeNode): Int = {
        // get longest path downward
        var res = -1e9.toInt
        def getLP(node: TreeNode): Int =
            if (node == null) 0 else {
                val (l, r) = (getLP(node.left), getLP(node.right))
                res = res max (node.value + l + r)
                (node.value + (l max r)) max 0
            }
        getLP(root)
        res
    }
}
