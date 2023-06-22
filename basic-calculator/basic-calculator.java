class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int operand = 0;
        int sign = 1;
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(Character.isDigit(cur)){
                operand = 10 * operand + cur - '0';
            }else if(cur == '+'){
                result += operand * sign;
                sign = 1;
                operand = 0;
            }else if(cur == '-'){
                result += operand * sign;
                sign = -1;
                operand = 0;
            }else if(cur == '('){  
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }else if(cur == ')'){
                result += sign * operand;
                result *= stack.pop();
                result += stack.pop();
                operand = 0;
            }
        }
        return result + (operand * sign);
    }
}