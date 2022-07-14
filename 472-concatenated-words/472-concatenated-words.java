class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (s1, s2)-> s1.length() - s2.length());
        
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        
        for(String word : words){
            if(isForm(word, set)){
                ans.add(word);
            }
            set.add(word);
        }
        return ans;
    }
    
    private boolean isForm(String word, Set<String> wordDict){
        boolean[] dp = new boolean[word.length()+1];
        
        dp[0] = true;
        for(int i = 0 ; i <= word.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDict.contains(word.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}