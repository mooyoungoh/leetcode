class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for(int i : nums1){
            set1.add(i);
        }
        for(int i : nums2){
            set2.add(i);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        
        for(int num : set1){
            if(!set2.contains(num)){
                ans.get(0).add(num);
            }
        }
        for(int num : set2){
            if(!set1.contains(num)){
                ans.get(1).add(num);
            }
        }
        return ans;
    }
}