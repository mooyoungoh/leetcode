class Solution {
    public int evalRPN(String[] tokens) {
        int a, b;
        Stack<Integer> stk = new Stack<>();
        for(String s : tokens){
            if(s.equals("+")){
                stk.add(stk.pop() + stk.pop());
            }else if(s.equals("-")){
                b = stk.pop();
                a = stk.pop();
                stk.add(a - b);
            }else if(s.equals("*")){
                stk.add(stk.pop() * stk.pop());
            }else if(s.equals("/")){
                b = stk.pop();
                a = stk.pop();
                stk.add(a / b);
            }else{
                stk.add(Integer.parseInt(s));
            }
        }
        return stk.pop();
    }
}