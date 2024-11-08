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
class Solution {
    public ListNode mergeTwoLists(ListNode n1, ListNode n2) {
    ListNode result;
    ListNode tail;

    if (n1 == null) {
      return n2;
    }

    if (n2 == null) {
      return n1;
    }

    if (n1.val <= n2.val) {
      result = n1;
      tail = n1;
      n1 = n1.next;
    } else {
      result = n2;
      tail = n2;
      n2 = n2.next;
    }
    // n1 (2)
    // n2 (1) -> (3)
    while (n1 != null && n2 != null) {
      if (n1.val <= n2.val) {
        tail.next = n1;
        n1 = n1.next;
      } else {
        tail.next = n2;
        n2 = n2.next;
      }
      tail = tail.next;
    }

    if (n1 == null) {
      tail.next = n2;
    } else {
      tail.next = n1;
    }
    return result;

    }
}
