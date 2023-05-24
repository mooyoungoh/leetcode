class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] ess = new int[n][2];
        for(int i = 0; i < n; i++){
            ess[i] = new int[]{nums2[i], nums1[i]};
        }
        Arrays.sort(ess, (a,b)-> b[0]-a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a,b)-> a-b);
        long res = 0, sum = 0;
        for(int[] es : ess){
            pq.offer(es[1]);
            sum += es[1];
            if(pq.size() > k)
                sum -= pq.poll();
            if(pq.size() == k) 
                res = Math.max(res, (es[0] * sum));
        }
        return res;
    }
}