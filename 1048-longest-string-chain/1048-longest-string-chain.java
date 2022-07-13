class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        
        int res = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for(String w: words){
            map.put(w,1);
            for(int i = 0 ; i < w.length(); i++){
                StringBuilder sb = new StringBuilder(w);
                String prev = sb.deleteCharAt(i).toString();
                
                if(map.containsKey(prev) && map.get(prev) + 1 > map.get(w)){
                    map.put(w, map.get(prev) + 1);
                } 
                
            }
            
            res = Math.max(map.get(w), res);
        }
        return res;
    }
}