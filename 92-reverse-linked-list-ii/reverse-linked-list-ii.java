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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) return head;

        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        dummyHead.next = head;

        for(int i = 0; i < left - 1; i++){
            cur = cur.next;
        }       

        ListNode tail = cur.next;

        for(int i = 0; i < right - left; i++){
            ListNode tmp = cur.next;
            cur.next = tail.next;
            tail.next = tail.next.next;
            cur.next.next = tmp;
        }
        
        return dummyHead.next;
    }
}