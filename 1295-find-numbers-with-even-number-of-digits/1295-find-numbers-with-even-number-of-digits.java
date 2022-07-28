class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        
        for(int i : nums){
            if(digit(i) % 2 == 0)
                ans++;
        }
        return ans;
    }
    
    private int digit(int num){
        int digit = 0;
        while(num != 0){
            num /= 10;
            digit++;
        }
        return digit;
    }
}