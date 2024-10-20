class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(n, 0,0,"", ans);
        return ans;
    }
    private void backtrack(int n, int numOpen, int numClose, String tmp, List<String> ans){
        //termination
        if(numOpen == numClose && numOpen == n){
            ans.add(tmp);
            tmp = "";
        }
        //recursion
        if(numOpen < n){
            backtrack(n, numOpen + 1, numClose, tmp + "(", ans);
        }
        if(numOpen > numClose){
            backtrack(n, numOpen, numClose + 1, tmp + ")", ans);
        }
        
    }
}