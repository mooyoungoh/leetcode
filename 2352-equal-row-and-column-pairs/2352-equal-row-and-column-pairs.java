class Solution {
    public int equalPairs(int[][] g) {

        int n = g.length;
        int res = 0;
		//convert the numbers in each row to a single string
        Map<String, Integer> sToFreq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) { 
                sb.append(g[i][j]);
                sb.append("+");
            }
            String s = sb.toString();
            sToFreq.put(s, sToFreq.getOrDefault(s, 0) + 1);
        }
        
		//convert the numbers in each col to string and find the matches
        for (int j = 0; j < n; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) { 
                sb.append(g[i][j]);
                sb.append("+");
            }
            String s = sb.toString();
            if (sToFreq.containsKey(s)) {
                res += sToFreq.get(s);
            }
        }
        return res;
    }
}