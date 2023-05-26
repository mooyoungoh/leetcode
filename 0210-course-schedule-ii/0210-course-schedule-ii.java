class Solution {
    public int[] findOrder(int numCourses, int[][] p) {
        int[] indegree = new int[numCourses];
        int[] ans = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<Integer>());
        }
        
        for(int[] edge : p){
            indegree[edge[0]]++;
            adjList.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) q.offer(i);
        }
        int index = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[index++] = node;
            for(int dest : adjList.get(node)){
                if(--indegree[dest] == 0){
                    q.offer(dest);
                }
            }
            adjList.get(node).clear();
        }
        return index == numCourses ? ans : new int[0];
    }
}