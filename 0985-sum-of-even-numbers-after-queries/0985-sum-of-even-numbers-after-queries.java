class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];

        int sum = 0;
        for(int num : nums){
            if(num % 2 == 0)
                sum += num;
        }

        int i = 0;

        for(int[] query : queries){
            int val = query[0];
            int index = query[1];
            
            // remove if even
            if(nums[index] % 2 == 0){
                sum -= nums[index];
            }

            nums[index] += val;

            if(nums[index] % 2 == 0){
                sum += nums[index];
            }


            ans[i++] = sum;

        }

        return ans;
    }
}