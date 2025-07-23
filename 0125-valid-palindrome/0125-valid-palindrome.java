class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            // skip non-alphanumeric left
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            // skip non-alphanumeric right
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if(Character.toUpperCase(s.charAt(left++)) != Character.toUpperCase(s.charAt(right--))) return false;
        }
        return true;
    }
}