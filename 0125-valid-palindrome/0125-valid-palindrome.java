class Solution {
    public boolean isPalindrome(String s) {
        char[] ca = s.toCharArray();
        int i = 0;
        int j = ca.length-1;
        while(i <= j){
            while(i < j && !Character.isLetterOrDigit(ca[i])) i++;
            while(i < j && !Character.isLetterOrDigit(ca[j])) j--;
            if(Character.toUpperCase(ca[i]) != Character.toUpperCase(ca[j])) return false;
            i++;
            j--;
        }
        return true;
    }
}