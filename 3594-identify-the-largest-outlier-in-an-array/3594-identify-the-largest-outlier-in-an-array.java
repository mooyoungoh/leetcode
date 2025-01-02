import java.util.Arrays;

class Solution {
    public int getLargestOutlier(int[] nums) {
        // Calculate the total sum of the numbers
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // Count the occurrences of each number
        Map<Integer, Integer> numCounts = new HashMap<>();
        for (int num : nums) {
            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
        }
        
        int largestOutlier = Integer.MIN_VALUE;
        
        // Iterate through the keys in the map
        for (int num : numCounts.keySet()) {
            // Calculate the potential outlier
            int potentialOutlier = totalSum - 2 * num;
            
            // Check if the potential outlier is valid
            if (numCounts.containsKey(potentialOutlier)) {
                if (potentialOutlier != num || numCounts.get(num) > 1) {
                    largestOutlier = Math.max(largestOutlier, potentialOutlier);
                }
            }
        }
        
        return largestOutlier;
    }
}
