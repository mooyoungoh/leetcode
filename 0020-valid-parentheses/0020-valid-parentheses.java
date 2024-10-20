class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        char[] ca = s.toCharArray();
        for(char c : ca){
            if(c == '(') stk.push(')');
            else if(c == '[') stk.push(']');
            else if(c == '{') stk.push('}');
            else{
                if(stk.isEmpty()) return false;
                if(c != stk.pop()) return false;
            }
        }

        return stk.isEmpty();
    }
}