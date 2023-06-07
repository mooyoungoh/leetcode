class Solution {
    public int minFlips(int a, int b, int c) {
        int ab = a | b;
        int xor = ab ^ c;
        int ans = 0;
        for(int i = 0; i < 32; i++){
            int mask = 1 << i;
            if((xor & mask) > 0){
                ans += (a & mask) == (b & mask) && (c & mask) == 0 ? 2 : 1;
            }
        }
        return ans;
    }
}