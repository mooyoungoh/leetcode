class Solution {
    
    public class WordCnt{
        String word;
        int count;
        public WordCnt(String word, int count){
            this.word = word;
            this.count = count;
        }
        
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, WordCnt> map = new HashMap<>();
        for(String word: words){
            if(!map.containsKey(word)){
                map.put(word, new WordCnt(word, 0));
            }else{
                map.get(word).count++;
            }
        }
        
        PriorityQueue<WordCnt> pq = new PriorityQueue<>(k, (a,b)-> a.count-b.count != 0 ? a.count-b.count : b.word.compareTo(a.word));
        
        for(WordCnt wordCnt : map.values()){
            pq.offer(wordCnt);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        List<String> ans = new ArrayList<>();
        
        while(!pq.isEmpty()){
            ans.add(0, pq.poll().word);
        }
        return ans;
    }
}