/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode walk = head;
        ListNode run = head;
        while(run.next != null){

            run = run.next;
            if(run.next != null){
                run = run.next;
                walk = walk.next;
            }
            if(run == walk) return true;
        }

        return false;
    }
}