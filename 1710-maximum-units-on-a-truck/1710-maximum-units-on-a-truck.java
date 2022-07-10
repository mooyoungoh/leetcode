class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]) ;
        
        int ans = 0;
        
                                  
        for(int[] b : boxTypes){                           
            if(truckSize == 0) return ans;
            int loop = b[0];
            while(loop-- > 0 && truckSize-- > 0 ){
                ans+= b[1];
                if(truckSize == 0) return ans;
            }
        }
        

        
        return ans;
    }
}


/*
[[1,3],[2,2],[3,1]], truckSize = 4
1 * 3 + 2 * 2 + 3 * 1


[[5,10],[2,5],[4,7],[3,9]], truckSize = 10
5 * 10 + 2 * 10 + 4 * 7 + 3*9 output = 91
50 + 20 + 28 + 29

[5,10], [3,9],[4,7]  10


*/