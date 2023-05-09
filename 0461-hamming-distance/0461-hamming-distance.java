class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int cnt = 0;
        while(xor != 0){
            cnt += xor & 1;
            xor = xor >> 1;
        }
        return cnt;
    }
}