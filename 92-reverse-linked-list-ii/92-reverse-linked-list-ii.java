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
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode curr = fakeHead.next;
        int i = 1;
        while (i < left) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        ListNode node = prev;
        while (i <= right) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
            i++;
        }
        node.next.next = curr;
        node.next = prev;
        return fakeHead.next;
    }
}