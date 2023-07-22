class Solution {
public int trailingZeroes(int n) {
    
    int zeroCount = 0;
    for (int i = 5; i <= n; i += 5) {
        int powerOf5 = 5;
        while (i % powerOf5 == 0) {
            zeroCount += 1;
            powerOf5 *= 5;
        }
    }
    return zeroCount;
}
}