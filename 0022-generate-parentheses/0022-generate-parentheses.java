class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(n, 0, 0, "", ans);
        return ans;
    }

    public void backtrack(int n, int left, int right, String tmp, List<String> ans){
        //termination
        if(left == n && right == n){
            ans.add(tmp);
            return;
        }
        //backtrack
        if(left < n){
            backtrack(n, left + 1, right, tmp + "(", ans);
        }
        if(right < left){
            backtrack(n, left, right + 1, tmp + ")", ans);
        }
    }
}