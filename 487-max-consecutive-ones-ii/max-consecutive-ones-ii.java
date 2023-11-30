class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int zero = 0;
        for(int left = 0, right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                zero++;
            }
            while(zero == 2){
                if(nums[left] == 0){
                    zero--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}