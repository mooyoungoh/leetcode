class Solution {
    public int lengthOfLastWord(String s) {
        String[] split = s.split("\\s");
        return split[split.length-1].length();
    }
}