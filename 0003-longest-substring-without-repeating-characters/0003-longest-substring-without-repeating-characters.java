class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int left = 0, right = 0; right < s.length(); right++){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right)), left);
            }
            map.put(s.charAt(right), right + 1);

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}