class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        if(target < letters[0] || target >= letters[n-1]) return letters[0];
        int i = 0;
        int j = n - 1;
        while(i < j){
            int mid = i + (j - i) / 2;
            if(letters[mid] <= target) i = mid + 1;
            else j = mid;
        }
        return letters[j];
    }
}