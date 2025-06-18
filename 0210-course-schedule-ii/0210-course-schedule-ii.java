class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        
        for(int[] p : prerequisites){
            indegree[p[0]]++;
            adjList.get(p[1]).add(p[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0)
                q.offer(i);
        }
        int[] ans = new int[numCourses];
        int index = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[index++] = node;
            for(int next : adjList.get(node)){
                if(--indegree[next] == 0)
                    q.offer(next);
            }
        }

        return index == numCourses ? ans : new int[0];
    }
}