class Solution {
    public int singleNumber(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int num : nums){
            if(!ans.contains(num)){
                ans.add(num);
            }else{
                ans.remove(new Integer(num));
            }
        }
        return ans.get(0);
    }
}