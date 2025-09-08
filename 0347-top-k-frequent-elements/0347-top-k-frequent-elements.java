class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a,b) -> map.get(a) - map.get(b));
        
        for(int key : map.keySet()){
            pq.offer(key);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] ans = new int[k];
        int index = 0;
        while(!pq.isEmpty()){
            ans[index++] = pq.poll();
        }

        return ans;
    }
}