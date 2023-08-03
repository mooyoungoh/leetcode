class Solution {
    public boolean isPalindrome(String s) {
        String copy = s;
        copy = copy.trim().replaceAll("[^a-zA-Z0-9]", "");
        int i = 0, j = copy.length()-1;
        while(i < j){
            if(Character.toLowerCase(copy.charAt(i)) != Character.toLowerCase(copy.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}