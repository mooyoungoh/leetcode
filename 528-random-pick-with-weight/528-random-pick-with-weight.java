class Solution {

    int cnt = 0;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    Random rnd = new Random();
        
    public Solution(int[] w) {
        for(int i = 0 ; i < w.length; i++){
            cnt+=w[i];
            map.put(cnt, i);
        }    
    }
    
    public int pickIndex() {
        int key = map.higherKey(rnd.nextInt(cnt));
        return map.get(key);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */