class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Map<Integer, Integer> map = new HashMap<>();

        for(int[] match : matches){
            int winner = match[0];
            int loser = match[1];

            map.putIfAbsent(winner, 0);
            map.put(loser, map.getOrDefault(loser, 0) + 1);
        }

        List<Integer> winnerList = new ArrayList<>();
        List<Integer> oneLoseList = new ArrayList<>();
    
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int player = entry.getKey();
            int loseCount = entry.getValue();

            if(loseCount == 0){
                winnerList.add(player);
            }else if(loseCount == 1){
                oneLoseList.add(player);
            }
        }
        
        Collections.sort(winnerList);
        Collections.sort(oneLoseList);


        ans.add(winnerList);
        ans.add(oneLoseList);
        
        return ans;

    }
}