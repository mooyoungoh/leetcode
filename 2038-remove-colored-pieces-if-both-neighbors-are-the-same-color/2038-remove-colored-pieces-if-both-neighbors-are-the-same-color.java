class Solution {
    public boolean winnerOfGame(String colors) {
        int aCnt = 0;
        int bCnt = 0;
        
        for(int i = 0; i < colors.length()-1;i++){
            if(colors.charAt(i) == 'A'){
                int j = i;
                int tmp = 1;
                while(j+1 < colors.length() && colors.charAt(j+1) == 'A'){
                    j++;
                    tmp++; 
                    if(tmp >= 3){
                        aCnt++;
                    }
                }
                i = j;
            }else if((colors.charAt(i) == 'B')){
                int j = i;
                int tmp = 1;
                while(j+1< colors.length() && colors.charAt(j+1) == 'B'){
                    j++;
                    tmp++; 
                    if(tmp >= 3){
                        bCnt++;
                    }
                }
                i = j;
            }
        }
        
        boolean ans = false;
        if(aCnt == bCnt){
            ans = false;
        }else if(aCnt < bCnt){
            ans = false;
        }else{
            ans = true;
        }
        
        System.out.println(aCnt);
        System.out.println(bCnt);
        
        return ans;
        
    }
}