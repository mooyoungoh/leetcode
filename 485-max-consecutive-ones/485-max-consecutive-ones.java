class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
    
        if(nums.length == 1)return nums[0];
        
        int ans = 0;
        
        for(int i = 0; i < nums.length; i++){
            int tmp = 0;
            if(nums[i] == 1)
                tmp = 1;
                while(i+1 < nums.length && nums[i+1] == 1){
                    i++;
                    tmp++;
                }
            ans = Math.max(ans, tmp);
        }
        
        return ans;
    }
}