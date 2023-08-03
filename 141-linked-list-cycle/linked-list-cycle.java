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
        ListNode runner = head;
        ListNode walker = head;
        while(runner.next != null){
            runner = runner.next;
            if(runner.next != null){
                runner = runner.next;
                walker = walker.next;
            }
            if(runner == walker) return true;
        }
        return false;
    }
}