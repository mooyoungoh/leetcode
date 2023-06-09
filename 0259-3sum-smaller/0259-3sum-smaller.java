class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int ans = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            int j = i + 1;
            int k = nums.length -1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < target){
                    ans += k - j; 
                    j++;
                }else{
                    k--;
                }
            }
        }
        return ans;
    }
}