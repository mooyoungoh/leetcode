class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        Arrays.sort(letters);
        for(int i = 0; i < letters.length; i++){
            if(letters[i] > target){
                return letters[i];
            }
        }
        return letters[0];
    }
}