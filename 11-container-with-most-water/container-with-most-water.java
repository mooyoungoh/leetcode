class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while(left <= right){
            int lower = Math.min(height[left], height[right]);
            int sum = lower * (right - left);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}