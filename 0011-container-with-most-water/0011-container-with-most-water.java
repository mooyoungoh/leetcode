class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while(left <= right){
            int shorterH = Math.min(height[left], height[right]);
            int vh = (right - left) * shorterH;

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }

            ans = Math.max(ans, vh);
        }

        return ans;
    }
}