class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ca = s.toCharArray();
        for(int i = 0; i < ca.length; i++){
            char c = ca[i];
            if(c == ')'){
                if(stack.isEmpty() || stack.pop() != '(') return false; 
            }else if(c == ']'){
                if(stack.isEmpty() || stack.pop() != '[') return false;
            }else if(c == '}'){
                if(stack.isEmpty() || stack.pop() != '{') return false;
            }else{
                stack.add(c);
            }
        }
        return stack.isEmpty(); 
    }
}