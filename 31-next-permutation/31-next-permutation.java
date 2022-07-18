class Solution {
    public void nextPermutation(int[] nums) {
        int a = nums.length-2;
        while(a>=0 && nums[a] >= nums[a+1])
            a--;
        
        if(a!=-1){
            int b = nums.length-1;
            while(nums[a] >= nums[b]) b--;
            swap(nums,a,b);
        }
        
        int start = a+1;
        int end = nums.length-1;
        while(start<end){
            swap(nums, start++,end--);
        }
    }
    
    private void swap(int[]nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] =tmp;
    }
}

/*
1. looping throu from back -> get one which is not ascending (a)
2. looping thoru from back again -> get one's index which is bigger than a 
3. swap a and b
4. sort index from a+1 to the end
*/