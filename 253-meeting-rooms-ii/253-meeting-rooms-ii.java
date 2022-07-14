class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int[] interval : intervals){
            if(pq.size() == 0){
                pq.add(interval[1]);
            }
            else{
                if(pq.peek()<=interval[0]){
                    pq.poll();
                }
                pq.add(interval[1]);
            }
        }
        return pq.size();
    }
}