class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the shorter array for O(log(min(m,n)))
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length, n = nums2.length;

        int low = 0, high = m;
        int half = (m + n + 1) / 2; // left side size (works for odd/even)

        while (low <= high) {
            int i = low + (high - low) / 2;   // cut in nums1
            int j = half - i;                 // cut in nums2

            // Borders (use sentinels to avoid bounds checks)
            int L1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int R1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int L2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int R2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // Valid partition?
            if (L1 <= R2 && L2 <= R1) {
                if (((m + n) & 1) == 1) {
                    // Odd total length: max of left side
                    return Math.max(L1, L2);
                } else {
                    // Even total length: average of middle pair
                    int leftMax = Math.max(L1, L2);
                    int rightMin = Math.min(R1, R2);
                    return (leftMax + rightMin) / 2.0;
                }
            } else if (L1 > R2) {
                // i too far right, move left
                high = i - 1;
            } else {
                // i too far left, move right
                low = i + 1;
            }
        }

        // Should never reach here if inputs are valid
        throw new IllegalArgumentException("Input arrays are not valid.");
    }
}
