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
    public ListNode middleNode(ListNode head) {
        ListNode runner = head;
        ListNode walker = head;
        
        while(runner.next != null){
            runner = runner.next;
            walker=walker.next;
            if(runner.next != null){
                runner = runner.next;
            }
        }
        return walker;
    }
}