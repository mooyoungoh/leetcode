class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }

        int letter = 0;
        int maxCount = -1;
        for(int i = 0; i < count.length; i++){
            if(maxCount < count[i]){
                maxCount = count[i];
                letter = i;
            }
        }

        if(maxCount > (s.length() + 1) / 2) return "";

        char[] ans = new char[s.length()];
        int index = 0;
        
        while(maxCount > 0){
            ans[index] = (char) (letter + 'a');
            index += 2;
            maxCount--;
        }

        for(int i = 0; i < count.length; i++){
            while(count[i] > 0){
                if(index > s.length() - 1){
                    index = 1;
                }
                ans[index] = (char) (i + 'a');
                index += 2;
                count[i]--;
            }
        }
        return new String(ans);
    }
}