class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.equals(needle)) return 0;
        
        int n = needle.length();
        for(int i = 0; i < haystack.length()-n+1; i++){
            if(haystack.substring(i, i+n).equals(needle)){
                return i;
            }
        }
        System.gc();
        return -1;
    }
}