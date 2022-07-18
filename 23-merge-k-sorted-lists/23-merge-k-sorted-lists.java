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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        
        ListNode ret = null;
        ListNode cur = null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a,b)-> a.val-b.val);
        for(ListNode node : lists){
            if(node==null)continue;
            pq.offer(node);
        }
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            if(node.next != null){
                pq.offer(node.next);
            }
            if(ret==null){
                ret = node;
                cur = node;
            }else{
                cur.next = node; // curent loop -> 
                cur = node; // next loop
            }
            
        }
        
        return ret;
    }
}