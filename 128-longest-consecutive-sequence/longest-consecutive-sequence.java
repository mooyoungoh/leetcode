class Solution {
    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        for(int num : nums) 
            set.add(num);
        
        int ans = 0;

        for(int num : nums){
            int len = 1; 
            int left = num - 1;
            int right = num + 1;
            while(set.contains(left)){
                set.remove(left);
                len++;
                left--;
            }
            while(set.contains(right)){
                set.remove(right);
                len++;
                right++;
            }
            ans = Math.max(ans, len);
        }

        return ans;
    }
}