class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        boolean find = false;
        for(int i = 0; i < nums.length; i++){
            String start = String.valueOf(nums[i]);
            while(i+1<nums.length && nums[i]+1==nums[i+1]){
                i++;
                find = true;
            }
            if(find){
                String end = String.valueOf(nums[i]);
                ans.add(start+"->"+end);
            }else{
                ans.add(start);
            }
            find = false;
        }
        return ans;
    }
}