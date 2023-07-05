class Solution {
    public int longestSubarray(int[] nums) {
        int zero = 0;
        int ans = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            zero += (nums[right] == 0 ? 1 : 0);
            while(zero > 1){
                zero -= (nums[left] == 0 ? 1 : 0);
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}