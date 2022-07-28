class Solution {
    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        
        for(int i = 1 ; i < nums.length; i++){
            int tmp = nums[i];
            for(int j = 0 ; j < i; j++){
                tmp += nums[j];
            }
            ans[i] = tmp;
        }
        return ans;
    }
}