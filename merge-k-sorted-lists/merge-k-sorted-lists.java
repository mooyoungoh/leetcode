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
        for(ListNode list : lists){
            if(list != null){
                pq.offer(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!pq.isEmpty()){
            cur.next = pq.poll();
            cur = cur.next;
            if(cur.next != null){
                pq.offer(cur.next);
            }
        }
        return dummy.next;
    }
}