class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();
        int[] seen = new int[n];
        for(List<Integer> e : edges){
            seen[e.get(1)] = 1;
        }
        for(int i = 0; i < n; i++){
            if(seen[i] == 0)
                ans.add(i);
        }
        return ans;
    }
}