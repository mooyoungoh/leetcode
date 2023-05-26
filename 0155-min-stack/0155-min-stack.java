class MinStack {

    public class Node{
        int val;
        int min;
        public Node(int val, int min){
            this.val = val;
            this.min = min;
        }
    }
    
    Stack<Node> stk;
    
    public MinStack() {
        stk = new Stack<>();
    }
    
    public void push(int val) {
        Node node = null;
        
        if(stk.isEmpty()){
            node = new Node(val, val);
        }else{
            node = new Node(val, val < stk.peek().min ? val : stk.peek().min);
        }
        stk.add(node);
    }
    
    public void pop() {
        stk.pop();
    }
    
    public int top() {
        return stk.peek().val;
    }
    
    public int getMin() {
        return stk.peek().min;
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