class Solution {
    public int maximumDifference(int[] nums) {
        int ans = -1;
        int premin = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > premin){
                ans = Math.max(ans, nums[i] - premin);
            }else{
                premin = nums[i];
            }
        }
        return ans;
    }
}