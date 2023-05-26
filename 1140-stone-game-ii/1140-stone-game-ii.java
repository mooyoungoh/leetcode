class Solution {
    private int[] sums;

// hash[i][M] store Alex max score from pile[i] for the given M
// i range (0, n)
// M range (0, n), actually M can at most reach to n/2
private int[][] hash;

public int stoneGameII(int[] piles) {

    if(piles == null || piles.length == 0) return 0;
    
    int n = piles.length;
    sums = new int[n];
    sums[n-1] = piles[n-1];
    
    //the sum from piles[i] to the end
    for(int i = n -2; i>=0;i--) {
        sums[i] = sums[i+1] + piles[i]; 
    }
    
    hash = new int[n][n];
    return helper(piles, 0, 1);
}

// helper method return the Alex max score from pile[i] for the given M
private int helper(int[] a, int i, int M) {
    // base case
    if(i == a.length) return 0;
    // when the left number of piles is less then 2M, the player can get all of them
    if(2*M >= a.length - i) {
        return sums[i];
    }
    // already seen before
    if(hash[i][M] != 0) return hash[i][M];
    
    //the min value the next player can get
    int min = Integer.MAX_VALUE;
    for(int x = 1; x <= 2 * M; x++){
        min = Math.min(min, helper(a, i+x, Math.max(M,x)));
    }
    
    // Alex max stones = all the left stones - the min stones Lee can get
    hash[i][M] = sums[i] - min;
    
    return hash[i][M];   
}
}