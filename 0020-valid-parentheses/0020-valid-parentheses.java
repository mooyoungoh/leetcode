class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == ')'){
                if(stk.isEmpty() || stk.pop() != '(') return false;
            }else if(c == ']'){
                if(stk.isEmpty() || stk.pop() != '[') return false;
            }else if(c == '}'){
                if(stk.isEmpty() || stk.pop() != '{') return false;
            }else{
                stk.add(c);
            }
        }
        return stk.isEmpty();
    }
}