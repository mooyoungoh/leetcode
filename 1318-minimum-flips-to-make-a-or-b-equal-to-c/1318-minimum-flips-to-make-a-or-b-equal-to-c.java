class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        int ab = a | b;
        int equal = ab ^ c;
        for(int i = 0; i < 32; i++){
            int mask = 1 << i;
            if((equal & mask) > 0){
                ans += (a & mask) == (b & mask) && (c & mask) == 0 ? 2 : 1;
            }
        }
        return ans;
    }
}



    
/*
 0010 0111
 0110 0010
 0110 0111
 
 0101 
*/
