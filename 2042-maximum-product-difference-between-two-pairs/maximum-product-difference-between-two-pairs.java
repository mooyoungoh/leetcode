class Solution {
    public int maxProductDifference(int[] nums) {
        int biggest = 0;
        int secondBiggest = 0;
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for(int num : nums){
            if(num > biggest){
                secondBiggest = biggest;
                biggest = num;
            }else{
                secondBiggest = Math.max(num, secondBiggest);
            }

            if(num < smallest){
                secondSmallest = smallest;
                smallest = num;
            }else{
                secondSmallest = Math.min(num, secondSmallest);
            }
        }
        return (biggest * secondBiggest) - (smallest * secondSmallest);
    }
}