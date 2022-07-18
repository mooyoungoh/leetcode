class MinStack {

    public class Node{
        int val;
        int min;
        public Node(int val, int min){
            this.val = val;
            this.min = min;
        }
        
    }
    
    Stack<Node> s = new Stack<>();
    
    public MinStack() {
        
    }
    
    public void push(int val) {
        Node node = null;
        if(s.isEmpty()){
            node = new Node(val, val);
        }else{
            node = new Node(val, s.peek().min < val ? s.peek().min : val);
        }
        s.push(node);
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek().val;
    }
    
    public int getMin() {
        return s.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */