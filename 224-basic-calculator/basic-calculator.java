class Solution {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        int result = 0;
        int sign = 1;
        int operand = 0;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(Character.isDigit(cur)){
                operand = operand * 10 + cur - '0';
            }
            else if(cur == '+'){
                result += operand * sign;
                sign = 1;
                operand = 0;
            }else if(cur == '-'){
                result += operand * sign;
                sign = -1;
                operand = 0;
            }else if(cur == '('){
                stk.add(result);
                stk.add(sign);
                sign = 1;
                result = 0;
            }else if(cur == ')'){
                result += operand * sign;
                result *= stk.pop();
                result += stk.pop();
                operand = 0;
            }
            
        }
        return result + operand * sign;
    }
}