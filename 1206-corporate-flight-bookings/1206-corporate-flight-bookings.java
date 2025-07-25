class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n]; // array to hold seat counts for each flight

        // 1. Mark the bookings using difference array technique
        for (int[] booking : bookings) {
            int start = booking[0] - 1;  // convert to 0-based index
            int end = booking[1] - 1;    // convert to 0-based index
            int seats = booking[2];

            ans[start] += seats; // add seats at the start index
            if (end + 1 < n) {
                ans[end + 1] -= seats; // remove seats right after the end index
            }
        }

        // 2. Accumulate the bookings with prefix sum to get actual seat counts
        for (int i = 1; i < n; i++) {
            ans[i] += ans[i - 1]; // add previous total to current
        }

        return ans;
    }
}
