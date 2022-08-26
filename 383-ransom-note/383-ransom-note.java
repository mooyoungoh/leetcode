class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        int[] dict = new int[26];
        for(int i = 0 ; i < magazine.length(); i++){
            dict[magazine.charAt(i) - 'a']++;
        }
    
        for(int i = 0 ; i < ransomNote.length(); i++){
            if(dict[ransomNote.charAt(i) - 'a'] > 0)
                dict[ransomNote.charAt(i) - 'a']--;
            else 
                return false;
        }
        return true;
    }
}