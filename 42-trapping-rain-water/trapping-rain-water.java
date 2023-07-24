class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int lmax = 0;
        int rmax = 0;
        while(left < right){
            lmax = Math.max(lmax, height[left]);
            rmax = Math.max(rmax, height[right]);
            if(lmax < rmax){
                ans += lmax - height[left++];
            }else{
                ans += rmax - height[right--];
            }
        }
        return ans;
    }
}