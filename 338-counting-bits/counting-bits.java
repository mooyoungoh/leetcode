class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for(int i = 1; i <= n; i++){
            
            int tmp = 0;
            int num = i;
            while(num > 0){
                tmp += (num & 1);
                num = num >> 1;
            }
            ans[i] = tmp;
        }

        return ans;
    }
}