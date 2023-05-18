class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordToFreq = new HashMap<>();
        for(String word : words){
            wordToFreq.put(word, wordToFreq.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<String> minHeap = new PriorityQueue<>(
            (a,b) -> (
                wordToFreq.get(a) == wordToFreq.get(b) ?
                b.compareTo(a) 
                : wordToFreq.get(a) - wordToFreq.get(b)
            )
        );
            
        for(String word : wordToFreq.keySet()){
            minHeap.offer(word);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }    
        List<String> res = new ArrayList<>();
        while(!minHeap.isEmpty()){
            res.add(0, minHeap.poll());
        }
        return res;
    }
}