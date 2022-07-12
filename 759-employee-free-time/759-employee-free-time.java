/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> schedule.get(a[0]).get(a[1]).start - schedule.get(b[0]).get(b[1]).start);
        
        for(int i = 0 ; i < schedule.size(); i++){
            pq.add(new int[]{i, 0});
        }
        
        List<Interval> res = new ArrayList<>();
        
        int prev = schedule.get(pq.peek()[0]).get(pq.peek()[1]).end;
        
        while(!pq.isEmpty()){
            int[] index = pq.poll();
            Interval interval = schedule.get(index[0]).get(index[1]);
            if(interval.start > prev){
                res.add(new Interval(prev, interval.start));
            }
            prev = Math.max(prev, interval.end);
            if(schedule.get(index[0]).size() > index[1] + 1){
                pq.add(new int[]{index[0], index[1] + 1});
            }
        }
        return res;
    }
}