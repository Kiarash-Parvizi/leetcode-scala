// Definition for singly-linked list.
class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}
object Solution {
    def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
        if (head == null) return null
        def len(node: ListNode, acc: Int = 0): Int = {
            if (node == null) return acc
            len(node.next, acc+1)
        }
        def removeNth(n: Int): ListNode = {
            println(n)
            var (nd,pre): (ListNode,ListNode) = (head, null)
            var i = 0
            while(i < n) { pre = nd; nd = nd.next; i+=1; }
            if (pre != null) {
                pre.next = nd.next; head;
            } else nd.next
        }
        removeNth(len(head)-n)
    }
}
