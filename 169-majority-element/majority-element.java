class Solution {
    public int majorityElement(int[] nums) {
        int x = -1;
        int count = 0;
        for(int num : nums){
            if(count == 0){
                x = num;
                count++;
            }else if(x != num){
                count--;
            }else{
                count++;
            }
        }
        return x;
    }
}