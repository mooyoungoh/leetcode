class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        
        boolean[] color = new boolean[n];
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                boolean res = isBi(i, graph, visited, color);
                if(!res) return false;
            }
        }
        return true;
    }
    private boolean isBi(int cur, int[][] graph, boolean[] visited, boolean[] color){
        for(int next : graph[cur]){
            if(!visited[next]){
                visited[next] = true;
                color[next] = !color[cur];
                boolean res = isBi(next, graph, visited, color);
                if(!res) return false;
            }else if(color[next] == color[cur]){
                return false;
            }
        }
        return true;
    }
}