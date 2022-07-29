class Solution {
    public int pivotIndex(int[] nums) {
        
        for(int i = 0 ; i < nums.length; i++){
            int left = 0;
            int right = nums.length-1;
            int lsum = 0;
            int rsum = 0;
            while(left < i){
                lsum += nums[left++];
            }
            while(right > i){
                rsum += nums[right--];
            }
            if(lsum == rsum)
                return i;
        }
        return -1;
    }
}