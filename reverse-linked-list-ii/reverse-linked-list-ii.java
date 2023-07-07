class Solution{
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m == n) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        dummy.next = head;

        for(int i = 0; i < m-1;i++) {
            p = p.next;
        }
        ListNode tail = p.next;
        
        for(int i = 0; i < n-m; i++) {
            ListNode tmp = p.next;
            p.next = tail.next;
            tail.next = tail.next.next;
            p.next.next = tmp;
        }
        return dummy.next;    
    }
}