class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        int count = 0;
        
        boolean[] b = new boolean[n];
        
        for(int i = 2; i < n; i++){
            if(!b[i]){
                count++;
                for(int j = i; j < n; j += i){
                    b[j] = true;
                }
            }    
        }
        return count;
    }
}