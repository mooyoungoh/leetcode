class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for(String in : path.split("/")) {
            if(in.length()==0 || in.equals(".")) {
                continue;
            }
            else if(in.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(in);
            }
        }
        
        StringBuilder res = new StringBuilder();
        for(String dir : stack) {
            res.append("/").append(dir);
        }

        return res.length() == 0 ? "/" : res.toString();
    }
}