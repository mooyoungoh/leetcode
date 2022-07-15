class Solution {
    public int findMinDifference(List<String> timePoints) {
        int min = Integer.MAX_VALUE;
        boolean[] minutes = new boolean[24*60];
        for(String s : timePoints){
            String[] time = s.split(":");
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);
            if(minutes[hour*60+minute]) 
                return 0;
            minutes[hour*60+minute] = true;
        }
        
        int maxx = -1;
        int minn = -1;
        for(int minute = 0; minute < minutes.length; minute++){
            if(minutes[minute]){
                if(maxx != -1){
                    min = Math.min(min, minute - maxx);
                }
                
                maxx = minute;
                
                if(minn == -1){
                    minn = minute;
                }
            }
        }
        System.out.println(min);
        return Math.min(min, Math.min(maxx - minn, minn + 24 * 60 - maxx));
    }
}