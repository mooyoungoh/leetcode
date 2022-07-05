class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums) set.add(num);
        
        for(int num : nums){
            int local = 1;
            int left = num-1;
            int right = num+1;
            while(set.contains(left)){
                set.remove(left);
                local++;
                left--;
            }
            while(set.contains(right)){
                set.remove(right);
                local++;
                right++;
            }
            res = Math.max(res, local);
        }
        return res;
    }
}