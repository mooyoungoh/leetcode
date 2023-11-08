class Solution {
    public String breakPalindrome(String palindrome) {

        char[] ar = palindrome.toCharArray();
        for(int i = 0; i < ar.length/2; i++){
            if(ar[i] != 'a'){
                ar[i] = 'a';
                return new String(ar);
            }
        }
        
        ar[ar.length-1] = 'b';
        return ar.length == 1 ? "" : new String(ar);
    }
}