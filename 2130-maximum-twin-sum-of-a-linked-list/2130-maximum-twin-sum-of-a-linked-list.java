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
        ListNode walker = middle(head);
        ListNode flip = reverse(walker);
        
        int ans = 0;
        
        while(head != null && flip != null){
            ans = Math.max(ans, head.val + flip.val);
            head = head.next;
            flip = flip.next;
        }
        return ans;
    }
    
    private ListNode middle(ListNode node){
        ListNode walker = node;
        ListNode runner = node;
        while(runner.next != null){
            runner = runner.next;
            walker = walker.next;
            if(runner.next != null){
                runner = runner.next;
            }
        }
        return walker;
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}