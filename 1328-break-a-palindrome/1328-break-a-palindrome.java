class Solution {
    public String breakPalindrome(String p) {
        char[] c = p.toCharArray();
        for(int i = 0 ; i < c.length/2; i++){
            if(c[i] != 'a'){
                c[i] = 'a';
                return String.valueOf(c);
            }
        }
        c[c.length-1] = 'b';
        return c.length == 1 ? "" : String.valueOf(c);
    }
}