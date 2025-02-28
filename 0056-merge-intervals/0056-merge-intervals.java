class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] a = intervals[i-1];
            int[] b = intervals[i];
            if(b[0] <= a[1]){
                b[0] = Math.min(a[0], b[0]);
                b[1] = Math.max(a[1], b[1]);
            }else{
                ans.add(a);
            }
        }
        ans.add(intervals[intervals.length-1]);
        return ans.toArray(new int[ans.size()][]);
    }
}