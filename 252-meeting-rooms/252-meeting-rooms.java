class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        
        if(intervals.length == 0 || intervals == null) return true;
        
        Arrays.sort(intervals, (a,b)-> a[0] - b[0]);
        
        int[] prev = intervals[0];
        
        for(int i = 1; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            int prevEnd = prev[1];
            if(prevEnd > start){
                return false;
            }else{
                prev = intervals[i];
            }
        }
        
        
        return true;
    }
}