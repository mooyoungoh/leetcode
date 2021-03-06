class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        for(int [] p : prerequisites){
            indegree[p[0]]++;
            adjList.get(p[1]).add(p[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i]==0) q.offer(i);
        }
        
        Set<Integer> set = new HashSet<>();
        
        while(!q.isEmpty()){
            int node = q.poll();
            set.add(node);
            for(int dest : adjList.get(node)){
                if(--indegree[dest] == 0) q.offer(dest);
            }
        }
        return set.size() == numCourses ? true : false;
    }
}