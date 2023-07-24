class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        swap(nums, 0, n - k - 1);
        swap(nums, n - k, n - 1);
        swap(nums, 0, n - 1);
    }
    void swap(int[] nums, int i, int j){
        while(i < j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }        
    }
}


/*
[1,2,3,4,5,6,7]

7 6 5 4 3 2 1

[7,1,2,3,4,5,6]
[6,7,1,2,3,4,5]

[5,6,7,1,2,3,4]



[-1,-100,3,99]

[99,-1,-100,3]
[3,99,-1,-100]
*/