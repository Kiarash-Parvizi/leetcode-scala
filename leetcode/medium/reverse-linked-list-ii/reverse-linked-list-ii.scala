// Definition for singly-linked list.
class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object Solution {
    def reverseBetween(head: ListNode, left: Int, right: Int): ListNode = {
        def f(head: ListNode, idx: Int): (ListNode,ListNode) = {
            if (idx >= right) return (head,head.next)
            val r = f(head.next, idx+1)
            head.next.next = head
            return r
        }
        var i = 1
        var (node, pre): (ListNode,ListNode) = (head, null)
        while (i < left) {
            pre = node
            node = node.next
            i += 1
        }
        val (nd_r, nd_rp) = f(node, i)
        node.next = nd_rp
        if (pre != null)
            pre.next = nd_r
        else return nd_r
        return head
    }
}

