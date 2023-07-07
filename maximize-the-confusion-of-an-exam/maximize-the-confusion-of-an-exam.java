class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxCount = 0;
        int maxLength = 0;
        int[] freq = new int[26];
        for(int left = 0, right = 0; right < answerKey.length(); right++){
            maxCount = Math.max(maxCount, ++freq[answerKey.charAt(right) - 'A']);
            if(right - left + 1 - maxCount > k){
                freq[answerKey.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}