class Solution {
       private Integer[][][] memo = new Integer[101][21][101];//cache
    private int MAX = (int)1e8, m, n;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.m = m; this.n = n;
        int res = dfs(houses, cost, 0, 0, target);
        return res >= MAX ? -1 : res;
    }

    private int dfs(int[] houses, int[][] cost, int houseIdx, int prevColor, int target){
        if(houseIdx == m || target < 0) return target == 0 ? 0 : MAX;//base cases

        if(memo[houseIdx][prevColor][target] != null) return memo[houseIdx][prevColor][target];//use memoized result
        
        if(houses[houseIdx] != 0){;//already painted only need to decide if it forms a new neighborhood or not
            int currentColor = houses[houseIdx];
            return memo[houseIdx][prevColor][target] = dfs(houses, cost, houseIdx + 1, currentColor, target - (currentColor != prevColor ? 1 : 0))    ;    
        }

        int res = MAX;
        for(int currentColor = 1; currentColor <= n; currentColor++) {//check all the colors and select min one
            int val = dfs(houses, cost, houseIdx + 1, currentColor, target - (currentColor != prevColor ? 1 : 0));//if prev color != current color means we have a new neighborhood so target - 1
            res = Math.min(res, val + cost[houseIdx][currentColor - 1]); //store the minimum
        }
        return memo[houseIdx][prevColor][target] = res;
    }
}