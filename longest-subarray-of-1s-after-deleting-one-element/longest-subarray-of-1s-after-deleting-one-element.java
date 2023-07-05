class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int zeroCount = 0;
        for(int left = 0, right = 0; right < nums.length; right++){
            zeroCount += (nums[right] == 0 ? 1 : 0);
            while(zeroCount > 1){
                zeroCount -= (nums[left] == 0 ? 1 : 0);
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}