class Solution {
    public long minimumTime(int[] time, int totalTrips) {
     long low = Long.MAX_VALUE, high = 0;
        for (int ti: time) {
            low = Math.min(low, ti);
        }
        high = low * totalTrips;
        while (low < high) {
            long mid = low + (high - low) / 2;

            if (check(mid, time, totalTrips)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean check(long t, int[] time, int totalTrips) {
        long trips = 0;
        for (int ti: time) {
            trips += t / ti;
        }
        if (trips >= totalTrips) {
            return true;
        }
        return false;
    }
}