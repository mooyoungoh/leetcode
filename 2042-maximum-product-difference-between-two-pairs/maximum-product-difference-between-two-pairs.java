class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int small = nums[0] * nums[1];
        int big = nums[nums.length-1] * nums[nums.length-2];
        int sum = big - small;
        
        return sum;
    }
}