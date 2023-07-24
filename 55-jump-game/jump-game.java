class Solution {
    public boolean canJump(int[] nums) {
        int index = nums.length - 1;
        int jump = nums[0];
        for(int i = 0; i <= jump; i++){
            jump = Math.max(jump, i + nums[i]);
            if(jump >= index) return true;
        }
        return false;
    }
}