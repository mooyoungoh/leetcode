class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = -1;
        double total = 0;
        for(int sal : salary){
            min = Math.min(min, sal);
            max = Math.max(max, sal);
            total += sal;
        }
        total = total - min - max;
        return (total / (salary.length -2));
    }
}