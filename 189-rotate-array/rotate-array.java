class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        swap(nums, 0, n - k - 1);
        swap(nums, n - k, n - 1);
        swap(nums, 0, n - 1);

    }

    public void swap(int[] nums, int i, int j){
        while(i < j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}