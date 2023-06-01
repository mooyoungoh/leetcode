class Solution {
    public List<String> letterCasePermutation(String s) {
        char[] c = s.toCharArray();
        List<String> ans = new ArrayList<>();
        backtrack(c, ans, 0);
        return ans;
    }
    private void backtrack(char[] arr, List<String> ans, int index){
        if(index == arr.length){
            ans.add(new String(arr));
        }else{
            char c = arr[index];
            if(Character.isAlphabetic(c)){
                arr[index] = Character.toUpperCase(c);
                backtrack(arr, ans, index+1);
                arr[index] = Character.toLowerCase(c);
                backtrack(arr, ans, index+1);
            }else{
                backtrack(arr, ans, index+1);
            }
        }
    }
}