class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) return false;
                
        int[] ss = new int[200];
        int[] tt = new int[200];
        
        for(int i = 0 ; i < s.length(); i++){
            int sc = s.charAt(i)-'0';
            int tc = t.charAt(i)-'0';
            ss[sc]++;
            tt[tc]++;
        }
        
        for(int i = 0 ; i < ss.length; i++){
            if(ss[i] != tt[i]){
                return false;
            }
        }
        return true;
    }
}