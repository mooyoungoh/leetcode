class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while(left <= right){
            int shoterHeight = Math.min(height[left], height[right]);
            int vh = (right - left) * shoterHeight;
            ans = Math.max(vh, ans);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}