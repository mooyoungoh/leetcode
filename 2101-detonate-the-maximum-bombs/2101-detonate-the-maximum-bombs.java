class Solution {
    // O(n^3) time where n == bombs.length, because in the worst case the graph is complete (each node can reach all other nodes so we have O(E) == O(V^2)) which means that the time complexity to compute the result is O(numberOfDFSes * costOfOneDFS) == O(V * (V + E)) == O(V^2 + V^3) == O(V^3).
// O(n^2) space, because in the worst case the graph is complete so we need O(n^2) space to store all edges in the graph. 
public int maximumDetonation(int[][] bombs) {
    // Create a directed graph.
    Map<Integer, List<Integer>> graph = new HashMap<>();    // Note that we could also use an array instead of a HashMap. List<Integer>[] = new List<>[bombs.length];
    
    for (int i = 0; i < bombs.length; ++i) graph.put(i, new ArrayList<>());    // Add one node for each bomb.
    
    // Add one directed edge from bombs[i] to bombs[j] iff. bombs[i] detonates bombs[j].
    // O(bombs.length^2) time, because we iterate through all pairs.
    // O(bombs.length^2) space, because in case of a complete graph we add an edge for each pair (each iteration of the inner for loop).
    for (int i = 0; i < bombs.length; ++i) {
        for (int j = i + 1; j < bombs.length; ++j) {
            // Check if we should add an edge from bombs[i] to bombs[j].
            if (detonates(bombs[i], bombs[j])) {
                graph.get(i).add(j);
            }
                
            // Check if we should add an edge from bombs[j] to bombs[i].
            if (detonates(bombs[j], bombs[i])) {
                graph.get(j).add(i);
            }
        }
    }
    
    // Compute the maximum number of reachable nodes for all starting positions (each node in the graph).
    // O(bombs.length^3) time, O(bombs.length) space.
    int result = 0;
    for (int i = 0; i < bombs.length; ++i) {
        result = Math.max(result, dfs(graph, new boolean[bombs.length], i));
    }
    return result;
}

// Returns true iff. the firstCircle contains the center of the second circle. We cast to long to avoid overflow problems. 
private boolean detonates(int[] firstCircle, int[] secondCircle) {
    return (long) (firstCircle[0] - secondCircle[0]) * (long) (firstCircle[0] - secondCircle[0])  + (long) (firstCircle[1] - secondCircle[1]) * (long) (firstCircle[1] - secondCircle[1]) <= (long) firstCircle[2] * firstCircle[2];
}
    
                
private int dfs(Map<Integer, List<Integer>> graph, boolean[] seen, int currNode) {
    if (seen[currNode]) return 0;
    seen[currNode] = true;
    int result = 1;
    for (int adjacentNode : graph.get(currNode)) {
        result += dfs(graph, seen, adjacentNode);
    }
    return result;
}

}