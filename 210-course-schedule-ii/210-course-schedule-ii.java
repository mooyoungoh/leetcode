class Solution {
    public int[] findOrder(int numCourses, int[][] pp) {
        /*
        1. indegree = 0 노드탐색
        2. 관련 edge 제거, indegree 업데이트
        
        */
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i = 0 ; i< numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] p : pp){
            indegree[p[0]]++;
            adjList.get(p[1]).add(p[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0 ; i< numCourses;i++){
            if(indegree[i] == 0) q.offer(i);
        }
        
        int[] ans = new int[numCourses];
        int index = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[index++] = node;
            for(int dist: adjList.get(node)){
                if(--indegree[dist] == 0) q.offer(dist);
            }
        }
        
        return index==numCourses?ans:new int[0];
    }
}