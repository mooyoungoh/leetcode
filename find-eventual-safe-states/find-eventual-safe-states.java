class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            for(int node : graph[i]){
                indegree[i]++;
                adjList.get(node).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            if(indegree[i] == 0)
                q.offer(i);
        }

        boolean[] safe = new boolean[n];
        while(!q.isEmpty()){
            int node = q.poll();
            safe[node] = true;
            for(int i : adjList.get(node)){
                if(--indegree[i] == 0){
                    q.offer(i);
                }
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(safe[i]){
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
}