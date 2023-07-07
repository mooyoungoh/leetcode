class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points == null) return 0;

        Arrays.sort(points, (a, b) ->{
            if(a[1] == b[1]) return 0;
            if(a[1] < b[1]) return -1;
            return 1;
        });    

        int arrow = 1;
        int firstEnd = points[0][1];
        for(int[] p : points){
            int start = p[0];
            int end = p[1];
            if(start > firstEnd){
                arrow++;
                firstEnd = end;
            }
        }
        return arrow;
    }
}