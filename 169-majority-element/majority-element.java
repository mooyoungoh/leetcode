class Solution {
    public int majorityElement(int[] nums) {
        int x = -1;
        int n = 0;
        for(int num : nums){
            if(n == 0){
                x = num;
            }
            if(x != num){
                n--;
            }else{
                n++;
            }
        }
        return x;
    }
}