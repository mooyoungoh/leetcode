class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            while(i < nums.length - 1 && nums[i] + 1 == nums[i + 1]){
                i++;
            }
            if(cur == nums[i]){
                ans.add("" + cur);
            }else{
                ans.add(cur + "->" + nums[i]);
            }
        }   
        return ans;
    }
}