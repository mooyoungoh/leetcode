class Solution {
    public int maxResult(int[] nums, int k) {
        		Deque<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			// pick the max number in the window size of K
			int max = queue.isEmpty() ? 0 : nums[queue.peekFirst()];
			// update the max value at the position
			nums[i] = nums[i] + max;
			// If nums[i] is max then remove the min values from queue
			while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
				queue.pollLast();
			}
			queue.add(i);
			// keep the window valid, if window size is increased
			while (!queue.isEmpty() && i - queue.peekFirst() + 1 > k) {
				queue.pollFirst();
			}
		}
		return nums[nums.length - 1];
    }
}


/*
[1,-5,-20,4,-1,3,-6,-3], k = 2


*/