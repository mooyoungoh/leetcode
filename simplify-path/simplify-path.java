class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for(String s : path.split("/")){
            if(s.length() == 0 || s.equals("."))
                continue;
            else if(s.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }else{
                stack.add(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String s : stack)
            sb.append("/").append(s);
        

        return sb.length() == 0 ? "/" : sb.toString();
    }
}