class Solution {
    public String reorganizeString(String s) {
        char[] charCount = new char[26];
        for(char c : s.toCharArray()){
            charCount[c - 'a']++;
        }

        int maxCount = 0, letter = 0;
        for(int i = 0; i < charCount.length; i++){
            if(maxCount < charCount[i]){
                maxCount = charCount[i];
                letter = i;
            }
        }

        //terminination
        if(maxCount > (s.length() + 1) / 2){
            return "";
        }

        char[] ans = new char[s.length()];
        int index = 0;
        while(charCount[letter] > 0){
            ans[index] = (char) (letter + 'a');
            index = index + 2;
            charCount[letter]--;
        }

        for(int i = 0; i < charCount.length; i++){
            while(charCount[i] > 0){
                if(index >= s.length()){
                    index = 1;
                }
                ans[index] = (char) (i + 'a');
                index = index + 2;
                charCount[i]--;
            }
        }
        return new String(ans);
    }
}