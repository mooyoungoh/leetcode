class Solution {
    public void nextPermutation(int[] nums) {
        // 뒤에서부터 탐색하면서 오름차순이 깨지는 index 확인(a)
        int a = nums.length-2;
        while(a>=0 && nums[a] >= nums[a+1])
            a--;
        
        if(a!=-1){
            // 다시 뒤에서 탐색하면서 a보다 큰 첫번째 인덱스를 확인(b)
            int b = nums.length-1;
            while(nums[a] >= nums[b]) b--;
            //a b swap
            swap(nums,a,b);
        }
        
        //a+1부터 끝까지 오름차순 정렬
        int start = a+1;
        int end = nums.length-1;
        while(start<end){
            swap(nums, start++,end--);
        }
    }
    
    private void swap(int[]nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

/*
1. looping throu from back -> get one which is not ascending (a)
2. looping thoru from back again -> get one's index which is bigger than a 
3. swap a and b
4. sort index from a+1 to the end
*/