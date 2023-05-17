class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        int degree = 0;
        for(int i = 0; i < nums.length; i++){
            first.putIfAbsent(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            if(degree < count.get(nums[i])){
                degree = count.get(nums[i]);
                res = i - first.get(nums[i]) + 1;
            }else if(degree == count.get(nums[i])){
                res = Math.min(res, i - first.get(nums[i]) + 1);
            }
        }
        return res;
    }
}