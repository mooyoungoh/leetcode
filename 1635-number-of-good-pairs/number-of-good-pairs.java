class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int num : nums){
            ans += map.getOrDefault(num, 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return ans;
    }
}