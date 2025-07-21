class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(n, ans, 0, 0, "");        
        return ans;
    }

    public void backtrack(int n, List<String> ans, int left, int right, String tmp){
        //term
        if(left == n && right == n){
            ans.add(tmp);
            return;
        }
        //back
        if(left < n){
            backtrack(n, ans, left+1, right, tmp+"(");
        }
        if(right < left){
            backtrack(n, ans, left, right + 1, tmp+")");
        }
    }
}