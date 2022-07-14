class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        
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
        if(word.length() == 0 || word == null) return false;
        
        boolean[] dp = new boolean[word.length()+1];
        dp[0] = true;
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 0 ; j < i; j++){
                if(dp[j] && wordDict.contains(word.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}