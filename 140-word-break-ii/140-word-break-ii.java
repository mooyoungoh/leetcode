class Solution {
    Map<String, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> al = new ArrayList<>();
        
        if(s.length() == 0 || s == null) return al;
        
        if(map.containsKey(s)) return map.get(s);
        
        if(wordDict.contains(s)) al.add(s);
        
        for(int i = 0 ; i < s.length(); i++){
            String t = s.substring(i);
            if(wordDict.contains(t)){
                List<String> tmp = wordBreak(s.substring(0, i), wordDict);
                if(tmp.size() != 0){
                    for(int j = 0 ; j < tmp.size(); j++){
                        al.add(tmp.get(j) + " " + t);
                    }
                }
            }
        }
        map.put(s, al);
        return al;
    }
}