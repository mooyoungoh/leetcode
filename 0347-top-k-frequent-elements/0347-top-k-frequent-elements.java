class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        
        Map<Integer, Integer> map = new HashMap<>(); // num - freq

        for(int num : nums){
            map.putIfAbsent(num, 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
        } 
        
         PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> map.get(b) - map.get(a));
        
        for(int i : map.keySet()){
            pq.offer(i);
        }
        
        for(int i = 0 ; i < k ; i++){
            ans[i] = pq.poll();
        }
        
        return ans;
    }
}