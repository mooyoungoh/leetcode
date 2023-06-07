class Solution {
    public int majorityElement(int[] nums) {
        int x = 0;
        int count = 0;
        for(int num : nums){
            if(count == 0){
                x = num;
            }
            if(num != x){
                count--;
            }else{
                count++;
            }
        }
        return x;
    }
}