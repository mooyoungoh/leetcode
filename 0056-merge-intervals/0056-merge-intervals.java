class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]>ans = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] prev = intervals[i-1];
            int[] cur = intervals[i];
            if(prev[1] >= cur[0]){
                cur[0] = Math.min(prev[0], cur[0]);
                cur[1] = Math.max(prev[1], cur[1]);
            }
            else{
                ans.add(prev);
            }
        }
        ans.add(intervals[intervals.length-1]);
        return ans.toArray(new int[ans.size()][]);
    }
}

/*
  prev   cur
[[1,3],[2,6],[8,10],[15,18]]
prev[1] > cur[0] // update
otherwise add into ans

*/