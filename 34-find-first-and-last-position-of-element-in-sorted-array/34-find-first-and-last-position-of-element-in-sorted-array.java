class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] ans = new int[]{-1,-1};
        
        if(nums == null || nums.length == 0) return ans;
        
        
        int i = 0; 
        int j = nums.length-1;
        
        while(i < j){
            int mid = (i + j) / 2;
            if(nums[mid] < target) i = mid+1;
            else j = mid;
        }
        
        if(nums[i]!=target) return ans;
        
        else ans[0] = i;
        
        j = nums.length-1;
        while(i < j){
            int mid = (i + j) /2  +1;
            if(nums[mid] > target) j = mid - 1;
            else i = mid;
        }
        ans[1] = j;
        
        return ans;
    }
}