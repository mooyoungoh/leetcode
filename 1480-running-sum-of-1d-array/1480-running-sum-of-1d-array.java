class Solution {
    public int[] runningSum(int[] nums) {
        int i = 1;
        int j = nums.length;
        while(i < j){
            nums[i] = nums[i] + nums[i-1];
            i++;
        }
        return nums;
    }
}