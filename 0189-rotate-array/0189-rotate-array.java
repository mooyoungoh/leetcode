class Solution {
    public void rotate(int[] nums, int k) {

        /*
        int n = nums.length;
        for(int i = 0; i < k % n; i++){
            int last = nums[n-1];
            for(int j = n-1; j > 0; j--){
                nums[j] = nums[j-1];
            }
            nums[0] = last;
        }
        */
        int n = nums.length;
        k = k % n;
        
        swap(nums, 0, n - k - 1);
        swap(nums, n - k , n - 1);
        swap(nums, 0, n-1);
        
    }
    private void swap(int[] nums, int i, int j){
        while(i < j){
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
            i++;
            j--;
        }
    }
}


/*

 [1,2,3,4,5,6,7]
 
 [7,1,2,3,4,5,6]
 [6,7,1,2,3,4,5]
 [5,6,7,1,2,3,4]
 
 [4,5,6,7,1,2,3]
 [3,4,5,6,7,1,2]
 [2,3,4,5,6,7,1]
 [1,2,3,4,5,6,7]
 
*/