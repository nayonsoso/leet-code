/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
[1,2,3]
Node(1) -> Node(2) -> Node(3)
  head

- reach to tail -> new head
- stack<Node> {Node(3), Node(2), Node(1)}
*/

class Solution {
    public ListNode reverseList(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        ListNode cur = head; // cur:Node(1)
        while(cur != null) { // false
            deque.push(cur); // deque:Node(3),Node(2), Node(1)
            cur = cur.next; // cur:null
        }

        if(head == null || head.next == null) {
            return head;
        }

        ListNode i = deque.pop(); // deque:
        ListNode newHead = i;
        while(!deque.isEmpty()) { // true
           ListNode j = deque.pop(); // j:Node(1)
           i.next = j; // list:Node(3) -> Node(2) <-> Node(1)
           i = j;
        }
        
        // Node(3) -> Node(2) -> Node(1) -> null
        i.next = null;
        return newHead;
    }
}
