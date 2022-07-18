class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
         
        for(int num : nums){
            if(pq.size() < k){
                pq.offer(num);
            }else{
                if(num > pq.peek()){
                    pq.poll();
                    pq.offer(num);
                }
            }
        }
        
        return pq.peek();
        
    }
}