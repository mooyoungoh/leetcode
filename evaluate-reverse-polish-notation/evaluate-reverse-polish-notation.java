class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                stk.add(stk.pop() + stk.pop());
            }else if(tokens[i].equals("-")){
                int a = stk.pop();
                int b = stk.pop();
                stk.add(b - a);
            }else if(tokens[i].equals("*")){
                stk.add(stk.pop() * stk.pop());
            }else if(tokens[i].equals("/")){
                int a = stk.pop();
                int b = stk.pop();
                stk.add(b / a);
            }else{
                stk.add(Integer.parseInt(tokens[i]));
            }
        }
        return stk.pop();
    }
}