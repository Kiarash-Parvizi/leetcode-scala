// Definition for singly-linked list.
class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

import collection.mutable.PriorityQueue
object Solution {
    def mergeKLists(lists: Array[ListNode]): ListNode = {
        val pq = PriorityQueue.empty[Int](implicitly[Ordering[Int]].reverse)
        for (hd <- lists) {
        var node = hd
        while (node != null) {
            pq += node.x; node = node.next
        }}
        if (pq.length == 0) return null
        val head = new ListNode(pq.dequeue())
        var node = head
        while (pq.length > 0) {
            node.next = new ListNode(pq.dequeue())
            node = node.next
        }
        head
    }
}
