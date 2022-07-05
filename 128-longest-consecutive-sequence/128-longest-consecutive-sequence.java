class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLen = 0;
        Set<Integer> hs = new HashSet<>();
        
        for(int i : nums) hs.add(i);
        
        for(int num : nums){
            int local = 1;
            int left = num-1;
            int right = num+1;
            while(hs.contains(left)){
                hs.remove(left);
                local++;
                left--;
            }
            while(hs.contains(right)){
                hs.remove(right);
                local++;
                right++;
            }
            maxLen = Math.max(local, maxLen);
        }
        return maxLen;
    }
}