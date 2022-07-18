class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(ans, tmp, visited, nums);
        return ans;
    }
    
    private void backtrack(List<List<Integer>> ans, List<Integer> tmp, boolean[] visited, int[] nums){
        if(tmp.size() == nums.length){
            ans.add(new ArrayList<>(tmp));
        }
        else{
            for(int i = 0 ; i < nums.length; i++){
                if(visited[i] || (i > 0 && nums[i] == nums[i-1] && visited[i-1]))
                    continue;
                tmp.add(nums[i]);
                visited[i] = true;
                backtrack(ans, tmp, visited, nums);
                visited[i] = false;
                tmp.remove(tmp.size()-1);
            }
        }
    }
}