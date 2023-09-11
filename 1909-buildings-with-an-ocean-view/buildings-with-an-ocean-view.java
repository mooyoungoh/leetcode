class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> ans = new ArrayList<>();
        int peak = 0;
        for(int i = heights.length - 1; i >= 0; i--){
            if(heights[i] > peak){
                ans.add(i);
            }
            peak = Math.max(peak, heights[i]);
        }

        int[] res = new int[ans.size()];
        int index = 0;
        for(int i = ans.size() - 1; i >= 0; i--){
            res[index++] = ans.get(i);
        }


        return res;
    }
}