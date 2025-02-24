class Solution {
    public boolean isValid(String s) {
        char[] cs = s.toCharArray();
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < cs.length; i++){
            char c = cs[i];
            switch(c){
                case ')':
                    if(stk.isEmpty() || stk.pop() != '(') return false;
                    break;
                case ']':
                    if(stk.isEmpty() || stk.pop() != '[') return false;
                    break;
                case '}':
                    if(stk.isEmpty() || stk.pop() != '{') return false;
                    break;
                default:
                    stk.push(c);
            }
        }
        return stk.isEmpty();
    }
}