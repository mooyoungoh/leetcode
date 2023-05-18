class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>(); // word - Freq
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(k, (a,b) -> map.get(a) == map.get(b) ? b.compareTo(a) : map.get(a) - map.get(b));
        for(String word : map.keySet()){
            pq.offer(word);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(0, pq.poll());
        }
        return ans;
    }
}