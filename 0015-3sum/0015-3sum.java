class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]) i++;
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < nums.length - 1 && nums[j] == nums[j + 1]) j++;
                    while(k > 0 && nums[k] == nums[k - 1]) k--;
                }else if(sum < 0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}