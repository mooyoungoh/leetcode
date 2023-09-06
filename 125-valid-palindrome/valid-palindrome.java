class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("\s", "");
        int i = 0;
        int j = s.length()-1;
        while(i <= j){
            char curi = s.charAt(i);
            char curj = s.charAt(j);
            if(!Character.isLetterOrDigit(curi)){
                i++;
            }else if(!Character.isLetterOrDigit(curj)){
                j--;
            }else{
                if(Character.toLowerCase(curi) != Character.toLowerCase(curj)){
                    return false;
                }
                    
                i++;
                j--;
            }
        }
        return true;
    }
}