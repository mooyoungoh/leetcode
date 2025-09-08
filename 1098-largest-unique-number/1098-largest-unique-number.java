class Solution {
    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);

        int ans = -1;
        for(int key : map.keySet()){
            if(map.get(key) == 1 && key > ans){
                ans = key;
            }
        }
        return ans;
    }
}