class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adjList = new ArrayList<>();
        
        boolean[] visited = new boolean[n];
        boolean[] color = new boolean[n];
        
        for(int i = 0 ; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int [] d : dislikes){
            int a = d[0] - 1;
            int b = d[1] - 1;
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        for(int i = 0 ; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                boolean res = isBiDfs(i, adjList, visited, color);
                if(!res) return false;
            }
        }
        return true;
    }
    
    private boolean isBiDfs(int cur, List<List<Integer>> adjList, boolean[] visited, boolean[] color){
        for(int next : adjList.get(cur)){
            if(!visited[next]){
                visited[next] = true;
                color[next] = !color[cur];
                boolean res = isBiDfs(next, adjList, visited, color);
                if(!res) return false;
            }else if(color[cur] == color[next]){
                return false;
            }
        }
        return true;
    }
    
}