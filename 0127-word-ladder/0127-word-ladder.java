class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordList.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int ans = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String next = q.poll();
                if(next.equals(endWord)) return ans;
                for(int j = 0; j < next.length(); j++){
                    char[] arr = next.toCharArray();
                    for(char k = 'a'; k <= 'z' ; k++){
                        if(arr[j] == k) continue;
                        arr[j] = k;
                        String str = new String(arr);
                        if(!visited.contains(str) && wordSet.contains(str)){
                            q.add(str);
                            visited.add(str);
                        }
                    }
                }
            }
            ans++;
        }       
        return 0;
    }
}