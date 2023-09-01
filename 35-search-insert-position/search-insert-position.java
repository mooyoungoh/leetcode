class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        
        int mid;
        while(i <= j){
            mid = i + (j - i) / 2;
            if(nums[mid] == target){
                return mid ;
            }else if(nums[mid] > target){
                j = mid - 1;
            }else{
                i = mid + 1;
            }
        }
        return i;
    }
}