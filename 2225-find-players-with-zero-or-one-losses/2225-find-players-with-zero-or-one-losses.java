class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {


        List<List<Integer>> ans = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        // Iterate through matches and track each players losses
        for(int[] match : matches){
            int winner = match[0];
            int loser = match[1];

            // Collect players with zero or exactly one loss
            map.putIfAbsent(winner, 0);
            map.put(loser, map.getOrDefault(loser, 0) + 1);
            
        }

        List<Integer> zeroLosses = new ArrayList<>();
        List<Integer> oneLosses = new ArrayList<>();

        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            int player = m.getKey();
            int losses = m.getValue();

            if(losses == 0){
                zeroLosses.add(player);
            }else if(losses == 1){
                oneLosses.add(player);
            }
        }

        // Sort both list in asc
        Collections.sort(zeroLosses);
        Collections.sort(oneLosses);
        
        // Return the groupped result

        ans.add(zeroLosses);
        ans.add(oneLosses);
        
        return ans;
    }
}