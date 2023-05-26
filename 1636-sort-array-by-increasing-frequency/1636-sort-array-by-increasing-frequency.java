class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for(int i : nums){
            list.add(i);
        }
        
        Collections.sort(list, (a, b) -> {
            if (!count.get(a).equals(count.get(b))) {
                return count.get(a) - count.get(b);
            }
            return b - a;
        });

        for(int i = 0; i < nums.length; i++){
            nums[i] = list.get(i);
        }
        
        return nums;
    }
}