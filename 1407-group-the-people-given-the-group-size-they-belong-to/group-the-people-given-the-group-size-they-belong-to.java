class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> group = new HashMap<>();
        for(int i = 0; i < groupSizes.length; i++){
            List<Integer> list = group.computeIfAbsent(groupSizes[i], k -> new ArrayList<>());
            list.add(i);
            if(list.size() == groupSizes[i]){
                ans.add(list);
                group.put(groupSizes[i], new ArrayList<>());
            }

        }
        return ans;
    }
}