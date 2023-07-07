class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;

        Arrays.sort(points, (o1, o2) -> {
            if(o1[1] == o2[1]) return 0;
            if(o1[1] < o2[1]) return -1;
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