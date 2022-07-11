class Logger {
    
    Map<String, Integer> map;
    int coolTime;
    
    public Logger() {
        map = new HashMap<>();
        coolTime = 10;    
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        if(!map.containsKey(message)){
            map.put(message, timestamp + this.coolTime);
            return true;
        }
        else{
            if(map.get(message) <= timestamp){
                map.put(message, timestamp + this.coolTime);
                return true;
            }
        }
        
        return false;
        
        
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */