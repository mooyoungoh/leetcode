class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gtotal = 0;
        int ctotal = 0;
        for(int i = 0; i < gas.length; i++){
            gtotal += gas[i];
            ctotal += cost[i];
        }
        if(ctotal > gtotal)
            return -1;

        int start = 0;
        int cost1 = 0;
        for(int i = 0; i < gas.length; i++){
            cost1 += gas[i] - cost[i];
            if(cost1 < 0){
                cost1 = 0;
                start = start = i + 1;
            }
        }
        return start;
    }
}