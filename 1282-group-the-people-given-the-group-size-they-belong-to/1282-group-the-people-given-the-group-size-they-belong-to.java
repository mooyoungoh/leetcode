class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < groupSizes.length; i++){
            map.putIfAbsent(groupSizes[i], new ArrayList<>());
            List<Integer> cur = map.get(groupSizes[i]);
            cur.add(i);
            if(cur.size() == groupSizes[i]){
                ans.add(cur);
                map.remove(groupSizes[i]);
            }
        }
        return ans;
    }
}