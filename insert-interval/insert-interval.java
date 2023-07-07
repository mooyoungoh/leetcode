class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();

        for(int[] slot : intervals){
            if(newInterval == null || slot[1] < newInterval[0]){
                ans.add(slot);
            }else if(slot[0] > newInterval[1]){
                ans.add(newInterval);
                ans.add(slot);
                newInterval = null;
            }else{
                newInterval[0] = Math.min(slot[0], newInterval[0]);
                newInterval[1] = Math.max(slot[1], newInterval[1]);
            }

        }
        
        if(newInterval != null)
            ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);
    }
}