class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int total = 0;
        for(int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i];
        }
        if(total < 0)
            return -1;
        
        int tank = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i++){
            tank += gas[i] - cost[i];
            if(tank < 0){
                start = i + 1;
                tank = 0;
            }
        }
        return start;
    }
}


/*
1 2 3 4 5 
3 4 5 1 2 

*/