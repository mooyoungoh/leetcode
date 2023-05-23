class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]); 
        
        int min = 0;
        for(int[] interval : intervals){
            if(!pq.isEmpty() && interval[0] >= pq.peek()[1]){
                pq.poll();
            }
            pq.offer(interval);
            
            min = Math.max(min, pq.size());
        }
        
        return min;
    }
}