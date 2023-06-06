class Solution {
    public int jump(int[] nums) {
        int farthest = 0;
        int jump = 0;
        int cur = 0;
        for(int i = 0; i < nums.length-1; i++){
            farthest = Math.max(farthest, nums[i] + i);
            if(farthest >= nums.length-1) return ++jump;
            if(i == cur){
                cur = farthest;
                jump++;
            }
        }
        return jump;
    }
}


