class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxf = 0;
        int ans = 0;
        for(int left = 0, right = 0; right < s.length(); right++){
            maxf = Math.max(maxf, ++freq[s.charAt(right) - 'A']);
            while(right - left + 1 - maxf > k){
                freq[s.charAt(left++) - 'A']--;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}