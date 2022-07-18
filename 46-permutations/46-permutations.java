class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backtrack(nums, ans, tmp);
        return ans;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> tmp){
        //base
        if(tmp.size() == nums.length){
            ans.add(new ArrayList<Integer>(tmp));
            return;
        }
        //recursion
        for(int num : nums){
            if(tmp.contains(num))continue;
            tmp.add(num);
            backtrack(nums, ans, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}