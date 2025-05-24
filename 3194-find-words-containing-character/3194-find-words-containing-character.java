class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        int index = 0;
        for(String word : words){
            char[] ca = word.toCharArray();
            for(int i = 0; i < ca.length; i++){
                if(ca[i] == x){
                    ans.add(index);
                    break;
                }
            }
            index++;
        }
        return ans;
    }
}