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
    public boolean isPalindrome(ListNode head) {
        ListNode runner = head, walker = head;
        while(runner != null){
            runner = runner.next;
            if(runner != null){
                runner = runner.next;
                walker = walker.next;
            }
        }
        
        
        ListNode tmp = reversedNode(walker);
        while(tmp!=null){
            if(head.val != tmp.val)return false;
            head = head.next;
            tmp = tmp.next;
        }
        
        return true;
    }
    
    
    public ListNode reversedNode(ListNode node){
        ListNode prev = null;
        while(node != null){
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}