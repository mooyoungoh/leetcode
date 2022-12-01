class Solution {
    public boolean halvesAreAlike(String s) {
        
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        
        int mid = s.length() / 2;
        int diff = 0;
        
        for(int i = 0; i < mid; i++){
            int j = i + mid;
            if(set.contains(s.charAt(i))){
                diff++;
            }
            if(set.contains(s.charAt(j))){
                diff--;
            }
            
        }
        return diff == 0;
    }
}