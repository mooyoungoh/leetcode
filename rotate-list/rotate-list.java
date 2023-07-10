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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;

        ListNode cur = head;
        int len = 1;
        while(cur.next != null){
            len++;
            cur = cur.next;
        }
        cur.next = head;
        int newIndex = len - k % len;
        for(int i = 0; i < newIndex; i++){
            cur = cur.next;
        }

        head = cur.next;
        cur.next = null;

        return head;

    }
}