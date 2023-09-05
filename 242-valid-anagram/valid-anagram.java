class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] sa = new int[26];
        int[] ta = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            sa[s.charAt(i) - 'a']++;
            ta[t.charAt(i) - 'a']++;
        }

        return Arrays.equals(sa, ta);
    }
}