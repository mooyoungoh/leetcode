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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ret = null;
        ListNode cur = null;
        while(list1 != null || list2 != null){
            if(list2 == null || (list1 != null && list1.val <= list2.val)){
                if(ret == null){
                    ret = list1;
                    cur = list1;
                }else{
                    cur.next = list1;
                    cur = list1;
                }     
                list1 = list1.next;
            }
            else{
                if(ret == null){
                    ret = list2;
                    cur = list2;
                }else{
                    cur.next = list2;
                    cur = list2;
                }     
                list2 = list2.next;
            }
        }
        return ret;
    }
}