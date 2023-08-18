class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int res = 0;
        Set<Integer> set[] = new HashSet[n];

        for(int i = 0; i < n; i++)
            set[i] = new HashSet<>();

        for(int r[] : roads){
            set[r[0]].add(r[1]);
            set[r[1]].add(r[0]);
        }

        for(int i = 0; i < n - 1; i++)
            for(int j = i + 1; j < n; j++)
                res = Math.max(res, set[i].size() + set[j].size() - (set[i].contains(j) ? 1 : 0));
        
        return res;
    }
}