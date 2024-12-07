/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode node) {
        List<ListNode> list = new ArrayList<>();

        while (node != null) {
            list.add(node);
            node = node.next;
        }

        int s = list.size() / 2;
        return list.get(s);
    }
}
