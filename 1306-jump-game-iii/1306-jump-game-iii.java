class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return helper(arr, start, visited);
    }
    
    public boolean helper(int[] arr, int start, boolean[] visited){
        if(start < 0 || start >= arr.length) return false;
        if(visited[start]) return false;
        if(arr[start] == 0) return true;
        visited[start] = true;
        return helper(arr, start + arr[start], visited) || helper(arr, start - arr[start], visited);
    }
}