class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int ans = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String word = q.poll();
                if(word.equals(endWord))return ans;
                for(int j = 0; j < word.length(); j++){
                    char[] arr = word.toCharArray();
                    for(char k = 'a'; k <= 'z'; k++){
                        if(arr[j] == k) continue;
                        arr[j] = k;
                        String newWord = new String(arr);
                        if(!visited.contains(newWord) && wordSet.contains(newWord)){
                            q.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
            ans++;
        }
        return 0;
    }
}