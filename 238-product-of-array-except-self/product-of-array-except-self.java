class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int right = 1;
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i != 0){
                left *= nums[i-1];
            }
            ans[i] = left;
        }

        for(int i = nums.length - 1; i >= 0; i--){
            if(i != nums.length - 1){
                right *= nums[i + 1];
            }
            ans[i] *= right;
        }
        return ans;
    }
}