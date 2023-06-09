class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0;
        int right = numbers.length-1;
        while(left < right){
            if(numbers[left] + numbers[right] == target){
                break;
            }if(numbers[left] + numbers[right] < target){
                left++;
            }else{
                right--;
            }
        }
        return new int[]{left+1, right+1};
    }
}