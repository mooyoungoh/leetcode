class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num); // Add all numbers to a set for O(1) lookup

        int maxLen = 0;

        for (int num : set) { // loop over the set (not nums to avoid duplicates)
            if (!set.contains(num - 1)) { // only start counting if num is the beginning of a sequence
                int currentNum = num;
                int currentLen = 1;

                while (set.contains(currentNum + 1)) { // count all consecutive numbers
                    currentNum++;
                    currentLen++;
                }

                maxLen = Math.max(maxLen, currentLen); // update maximum length
            }
        }

        return maxLen;
    }
}
