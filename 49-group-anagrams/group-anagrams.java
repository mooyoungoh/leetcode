class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();
        for(String s : strs){
            char[] ca = new char[26];
            for(int i = 0; i < s.length(); i++){
                ca[s.charAt(i) - 'a']++;
            }
            String key = String.valueOf(ca);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new LinkedList<>(map.values());
    }
}