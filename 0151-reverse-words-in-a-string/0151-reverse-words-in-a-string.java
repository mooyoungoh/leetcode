class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split(" +");
        int i = 0;
        int j = arr.length-1;
        while(i < j){
            String tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++; j--;
        }
        return String.join(" ", arr);
    }
}