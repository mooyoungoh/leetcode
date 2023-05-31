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
    public ListNode detectCycle(ListNode head) {
        ListNode walk = head;
        ListNode run = head;
        while(run != null){
            run = run.next;
            if(run != null){
                run = run.next;
                walk = walk.next;
            }
            if(walk == run){
                break;
            }
        }
        if(run == null){
            return null;
        }
        ListNode check = head;
        while(check != walk){
            check = check.next;
            walk = walk.next;
        }
        return walk;
    }
}