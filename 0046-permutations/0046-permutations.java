class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, nums, new ArrayList<>());
        return ans;
    }
    
    private void backtrack(List<List<Integer>> ans, int[] nums, List<Integer> tmp){
        //base
        if(tmp.size() == nums.length){
            ans.add(new ArrayList<>(tmp));
        }
        
        //recurisve
        for(int num : nums){
            if(tmp.contains(num)){
                continue;
            }
            tmp.add(num);
            backtrack(ans, nums, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}