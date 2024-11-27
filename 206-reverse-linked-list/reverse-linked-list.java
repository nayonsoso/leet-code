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

    Node(1) -> Node(2) -> Node(3) ->
 <- Node(1)    Node(2) -> Node(3) ->
 <- Node(1) <- Node(2)    Node(3) ->
 <- Node(1) <- Node(2) <- Node(3)

cur : 앞으로 한칸씩 전진
그런데 문제는 방향이 후퇴하고 있으므로 연결이 끊어짐


*/

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head; // cur:Node(1)
        ListNode next = null;
        ListNode past = null;

        while(cur != null) {
            next = cur.next;
            cur.next = past;
            past = cur;
            cur = next;
        }

        return past;
    }
}
