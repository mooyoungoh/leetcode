class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            if(map.containsKey(target-cur)){
                int[] ans = new int[2];
                ans[0] = map.get(target-cur);
                ans[1] = i;
                return ans;
            }
            map.put(cur, i);
        }

        return null;
    }
}