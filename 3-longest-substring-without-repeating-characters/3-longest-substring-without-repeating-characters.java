class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int maxLen = 0;
        int start = -1;
        int[] dict = new int[256];
        Arrays.fill(dict, -1);
        for(int i = 0 ; i < s.length(); i++){
            if(dict[s.charAt(i)] > start){
                start = dict[s.charAt(i)];
            }
            dict[s.charAt(i)] = i;
            maxLen = Math.max(maxLen, i - start);
        }
        return maxLen;
    }
}