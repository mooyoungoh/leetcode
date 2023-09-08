class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>prev = new ArrayList<>();
        for(int i = 1; i <= numRows; i++){
            List<Integer> cur = new ArrayList<>();
            for(int j = 1; j <= i; j++){
                if(j == 1 || j == i){
                    cur.add(1);
                }else{
                    cur.add(prev.get(j - 1) + prev.get(j-2));
                }
            }
            prev = cur;
            ans.add(cur);
        }
        return ans;
    }
}