class Solution {
    public int[] sortByBits(int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        for(int i = 0 ; i < arr.length; i++){
            int count = CalculateBit(arr[i]);
            pq.offer(new int[]{count, arr[i]});
        }
        int [] result = new int[arr.length];
        int index = 0;
        while(!pq.isEmpty()){
            result[index++] = pq.poll()[1];
        }
        return result;
    }
    
    private int CalculateBit(int n){
        int count = 0;
        while(n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
}