/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node newHead = new Node(head.val);
        Node cur = newHead;
        Map<Node, Node> map = new HashMap<>();
        map.put(head, newHead);
        while(head != null){
            if(head.next != null){
                if(!map.containsKey(head.next)){
                    map.put(head.next, new Node(head.next.val));
                }
                cur.next = map.get(head.next);
            }

            if(head.random != null){
                if(!map.containsKey(head.random)){
                    map.put(head.random, new Node(head.random.val));
                }
                cur.random = map.get(head.random);
            }
            
            head = head.next;
            cur = cur.next;
        }
        return newHead;
    }
}




