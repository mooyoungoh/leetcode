class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, 0, 0, n, "");
        return ans;
    }
    public void backtrack(List<String> ans, int openNum, int closeNum, int n, String tmp){
        //base
        if(openNum == n && closeNum == n){
            ans.add(tmp);
            return;
        }
        //recursion
        if(openNum < n){
            backtrack(ans, openNum + 1, closeNum, n, tmp + "(");
        }

        if(closeNum < openNum){
            backtrack(ans, openNum, closeNum + 1, n, tmp + ")");
        }

    }
}