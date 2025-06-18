class Solution {
    public int maxFrequency(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for (int b : count.keySet()) {
            res = Math.max(res, kadane(nums, k, b));
        }

        return count.getOrDefault(k, 0) + res;
    }

    private int kadane(int[] nums, int k, int b) {
        int res = 0, cur = 0;
        for (int num : nums) {
            if (num == k) {
                cur--;
            }
            if (num == b) {
                cur++;
            }
            if (cur < 0) {
                cur = 0;
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}
