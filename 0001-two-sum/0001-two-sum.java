class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            if(map.containsKey(target - cur)){
                return new int[]{i, map.get(target - cur)};
            }
            map.put(cur, i);
        }
        
        return null;
    }
}