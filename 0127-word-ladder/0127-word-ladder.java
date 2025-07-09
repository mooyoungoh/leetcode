class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for(String word : wordList){
            wordSet.add(word);
        }

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
                    char[] arr = word.toCharArray();
                    for(char k = 'a'; k <= 'z'; k++){
                        if(arr[j] == k) continue;
                        arr[j] = k;
                        String newWord = new String(arr);
                        if(wordSet.contains(newWord) && !visited.contains(newWord)){
                            visited.add(newWord);
                            q.offer(newWord);
                        }
                    }
                }
            }
            ans++;
        }

        return 0;
    }
}