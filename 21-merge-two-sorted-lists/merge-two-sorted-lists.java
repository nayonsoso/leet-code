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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /*
        result = new ListNode();
        cursor = result;
        loop : until list1 is null or list2 is null
            compare each head
            if list1's head is smaller
                add list1's head to cursor's next
                move cursor next
                update list1 (delete head)
            if list2's head is smaller
                add list2's head to cursor's next
                move cursor next
                update list2 (delete head)
        end loop

        add left list to cursor
        */

        ListNode result = new ListNode();
        ListNode cursor = result;

        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cursor.next = list1;
                list1 = list1.next;
            } else {
                cursor.next = list2; // 
                list2 = list2.next;
            }
            cursor = cursor.next;
        }

        cursor.next = (list1 == null ? list2 : list1);
        return result.next;
    }
}
