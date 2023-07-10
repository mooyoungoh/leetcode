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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        int length = 0;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        length -= n;
        cur = dummy;
        while(length > 0){
            length--;
            cur = cur.next;
        }

        cur.next = cur.next.next;
        return dummy.next;

    }
}