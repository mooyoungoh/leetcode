class Solution {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        int operand = 0;
        int sign = 1;
        int result = 0;
        for(char c : s.toCharArray()){
 
            if(Character.isDigit(c)){
                operand = operand * 10 + (c - '0');
            }
            if(c == '+'){
                result += operand * sign;
                sign = 1;
                operand = 0;
            }
            if(c == '-'){
                result += operand * sign;
                sign = -1;
                operand = 0;
            }
            if(c == '('){
                stk.push(result);
                stk.push(sign);
                sign = 1;
                result = 0;
            }
            if(c == ')'){
                result += operand * sign;
                result *= stk.pop();
                result += stk.pop();
                operand = 0;
            }
        }
        return result + (operand * sign);
    }
}