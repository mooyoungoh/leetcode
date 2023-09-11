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
        for(int i = 0; i < ans.size(); i++){
            res[i] = ans.get(i);
        }

        Arrays.sort(res);

        return res;
    }
}