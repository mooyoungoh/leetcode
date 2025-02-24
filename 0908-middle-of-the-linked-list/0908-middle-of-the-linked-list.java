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
        ListNode walk = head;
        ListNode run = head;
        
        while(run.next != null){
            run = run.next;
            walk = walk.next;
            if(run.next != null){
                run = run.next;
            }
        }
        return walk;
    }
}