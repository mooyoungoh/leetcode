class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length,i=n-2;
        int goal=n-1;
        while(i>=0){
            if(i+nums[i]>=goal){
                goal=i;
                i--;
            }else{i--;}
        }
        return goal==0?true:false;
    }
}