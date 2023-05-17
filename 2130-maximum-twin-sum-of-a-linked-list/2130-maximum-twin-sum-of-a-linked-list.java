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
    public int pairSum(ListNode head) {
        ListNode middle = half(head);
        ListNode rev = reverse(middle);
        
        int ans = 0;
        
        while(head != null && rev != null){
            ans = Math.max(head.val + rev.val, ans);
            head = head.next;
            rev = rev.next;
        }
        return ans; 
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    private ListNode half(ListNode head){
        ListNode walker = head;
        ListNode runner = head;
        while(runner != null){
            runner = runner.next;
            walker = walker.next;
            if(runner != null){
                runner = runner.next;
            }
        }
        return walker;
    }
}