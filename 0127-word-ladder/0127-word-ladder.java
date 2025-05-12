class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int ans = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String word = q.poll();
                if(word.equals(endWord)) return ans;
                for(int j = 0; j < word.length(); j++){
                    char[] wordArr = word.toCharArray();
                    for(char k = 'a'; k <= 'z'; k++){
                        if(wordArr[j] == k) continue;
                        wordArr[j] = k;
                        String newString = new String(wordArr);
                        if(!visited.contains(newString) && wordSet.contains(newString)){
                            q.add(newString);
                            visited.add(newString);
                        }
                    }
                }
            }
            ans++;
        }       
        return 0;
    }
}