class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] sa = new char[26];
        char[] ta = new char[26];
        for(int i = 0; i < s.length(); i++){
            sa[s.charAt(i)-'a']++;
            ta[t.charAt(i)-'a']++;
        }
        return new String(sa).equals(new String(ta));
    }
}