class Solution {
    public boolean isValid(String s) {
        if(s.length() <= 1)return false;
        Stack<Character> stk = new Stack<>();
        char[] ac = s.toCharArray();
        for(char c : ac){
            if(c == '(' || c == '[' || c == '{')
                stk.push(c);
            else{
                if(stk.empty())return false;
                if(c == ')' && stk.pop() != '(') return false;
                if(c == ']' && stk.pop() != '[') return false;
                if(c == '}' && stk.pop() != '{') return false;
            }
        }
        return stk.isEmpty();
    }
}