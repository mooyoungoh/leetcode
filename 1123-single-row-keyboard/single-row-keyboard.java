class Solution {
    int calculateTime(String keyboard, String word) {
        int ans = 0;
        int index = 0;
        for(int i = 0; i < word.length(); i++){
            for(int j = 0; j < keyboard.length(); j++){
                if(word.charAt(i) == keyboard.charAt(j)){
                    int diff = Math.abs(j - index);
                    ans += diff;
                    index = j;
                }
            }
        }
        return ans;
    }
};

