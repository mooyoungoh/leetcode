class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxCount = 0;
        int maxLength = 0;
        int countT = 0;
        int countF = 0;
        for(int left = 0, right = 0; right < answerKey.length(); right++){
            if(answerKey.charAt(right) == 'T')
                countT++;
            else
                countF++;

            while(Math.min(countT, countF) > k){
                if(answerKey.charAt(left++) == 'T'){
                    countT--;
                }else{
                    countF--;
                }
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}