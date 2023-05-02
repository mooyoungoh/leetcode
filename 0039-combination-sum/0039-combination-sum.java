class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    Arrays.sort(candidates);
    combinationSumHelper(candidates, target, 0, current, result);
    return result;
    }
    private void combinationSumHelper(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
    if (target == 0) {
        result.add(new ArrayList<>(current));
        return;
    }
    for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
        current.add(candidates[i]);
        combinationSumHelper(candidates, target - candidates[i], i, current, result);
        current.remove(current.size() - 1);
    }
}
}