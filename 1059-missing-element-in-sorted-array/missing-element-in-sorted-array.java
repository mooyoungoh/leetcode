class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;

        for(int i = 1; i < n; i++){
            int gap = nums[i] - nums[i-1] - 1;
            if(gap >= k){
                return nums[i-1] + k;
            }
            k-= gap;
        }

        return nums[n-1] + k;
    }
}