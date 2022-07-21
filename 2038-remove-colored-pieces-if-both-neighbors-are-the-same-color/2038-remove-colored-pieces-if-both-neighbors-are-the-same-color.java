class Solution {
    public boolean winnerOfGame(String s) {
        int a = 0, b = 0;
        
        for(int i=1; i<s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i-1) && s.charAt(i) == s.charAt(i+1)){
                if(s.charAt(i) == 'A')
                    a++;
                else
                    b++;
			}
        }
                    
        return a>b;
    }
}