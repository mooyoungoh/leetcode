class Solution {
    public String reorganizeString(String s) {
        int[] letter = new int[26];
        for(char c : s.toCharArray()){
            letter[c - 'a']++;
        }

        int count = 0;
        int mostLetter = 0;
        for(int i = 0; i < letter.length; i++){
            if(letter[i] > count){
                count = letter[i];
                mostLetter = i;
            }
        }

        if(count > (s.length() + 1) / 2) return "";

        char[] ans = new char[s.length()];
        int index = 0;
        
        while(letter[mostLetter] > 0){
            ans[index] = (char) (mostLetter + 'a');
            index += 2;
            letter[mostLetter]--;
        }
        
        for(int i = 0; i < letter.length; i++){
            while(letter[i] > 0){
                if(index > s.length() - 1){
                    index = 1;
                }
                ans[index] = (char) (i + 'a');
                index += 2;
                letter[i]--;
            }
        }

        return new String(ans);

    }
}