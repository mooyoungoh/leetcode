class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int ans = 0;
        for(int i = citations.length - 1; i >=0 ; i--){
            int paper = citations.length - i;
            if(citations[i] >= paper){
                ans = paper;
            }
        }
        return ans;
    }
}