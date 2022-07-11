class Solution {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        for(int i = 0, sign = 1; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(s.charAt(i))){
                int num = s.charAt(i) - '0';
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))){
                    num = num * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                stk.push(stk.pop() + sign * num);
            }else if(c == '+'){
                sign = 1;
            }else if(c == '-'){
                sign = -1;
            }else if(c == '('){
                stk.push(sign);
                stk.push(0);
                sign = 1;
            }else if(c == ')'){
                stk.push(stk.pop() * stk.pop() + stk.pop());
            }
        }
        return stk.pop();
    }
}