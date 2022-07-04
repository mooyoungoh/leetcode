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
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a,b) -> a.val - b.val);
        
        ListNode ret = null;
        ListNode cur = null;
        
        for(ListNode node : lists){
            if(node!=null)pq.offer(node);
        }
        
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            if(node.next!=null) pq.offer(node.next);
            if(ret == null){
                ret = node;
                cur = node;
            }else{
                cur.next = node;
                cur = node;
            }
        }
        return ret;
    }
}