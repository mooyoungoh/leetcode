class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        
        Set<List<Integer>> set = new HashSet<>();
        
        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] > 0) continue;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    set.add(Arrays.asList(nums[i], nums[j],nums[k]));
                    j++;
                    k--;
                }else if(sum < 0){
                    j++;
                }else if(sum > 0){
                    k--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}