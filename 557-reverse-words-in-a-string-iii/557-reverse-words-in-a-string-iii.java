class Solution {
    public String reverseWords(String s) {
        String ans = "";
        
        String[] sa = s.split(" ");
        for(int i = 0 ; i < sa.length; i++){
            String reversed = re(sa[i]);
            ans += reversed;
            if(i != sa.length-1)
                ans += " ";
        }
        return ans;
        
    }
    
    public String re(String s){
        int i = 0;
        int j = s.length()-1;
        
        char[] ca = s.toCharArray();
        
        while(i < j){
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
            i++;
            j--;
        }
        
        return new String(ca);
    }
}