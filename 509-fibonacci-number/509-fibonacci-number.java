class Solution {
    int[] memo = new int[31];
    
    public int fib(int n) {
    
        if(n <= 1)
            return n;
        else{
            if(memo[n] > 0)
                return memo[n];
            else
                return fib(n-1) + fib(n-2);
        }
    }
}