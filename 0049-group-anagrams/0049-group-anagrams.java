class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] ca = new char[26];
            for(char c : s.toCharArray()){
                ca[c-'a']++;
            }
            String key = new String(ca);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        } 
        return new ArrayList<>(map.values());
    }
}