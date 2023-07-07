class Solution {
    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<>();
        for(String s : path.split("/")){
            if(s.length() == 0 || s.equals(".")){
                continue;
            }else if(s.equals("..")){
                if(!stk.isEmpty())
                    stk.pop();
            }else{
                stk.add(s);
            }
        }

        StringBuilder s = new StringBuilder();
        for(String ss : stk){
            s.append("/").append(ss);
        }
        return s.length() == 0 ? "/" : s.toString();
    }
}