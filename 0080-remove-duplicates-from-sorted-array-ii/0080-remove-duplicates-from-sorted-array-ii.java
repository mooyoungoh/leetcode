class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        int k = 1;
        boolean check = false;
        for(int i = 1; i < nums.length;){
            while(i < nums.length && nums[i] == nums[i-1]){
                i++;
                check = true;
            }
            if(check)
                i--;
            nums[index++] = nums[i];
            check = false;
            i++;
        }
        return index;
    }
}