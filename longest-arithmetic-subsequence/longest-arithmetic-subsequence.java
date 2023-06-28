class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if(n <= 2){
            return n;
        }
        Map<Integer, Integer>[] dp = new HashMap[n];
        int ans = 2;
        for(int i = 0; i < nums.length; i++){
            dp[i] = new HashMap<>();
            for(int j = 0; j < i; j++){
                int diff = nums[i] - nums[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                ans = Math.max(ans, dp[i].get(diff));
            }
        }
        return ans;
    }
}