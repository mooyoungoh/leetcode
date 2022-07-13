class Solution {
    
    public class Pair{
        int time;
        String web;
        public Pair(int time, String web){
            this.time = time;
            this.web = web;
        }
    }
    
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair>> map = new HashMap<>();
        for(int i = 0; i < username.length; i++){
            map.putIfAbsent(username[i], new ArrayList<>());
            map.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }
        
        Map<String, Integer> count = new HashMap<>();
        
        String res ="";
        
        for(String key : map.keySet()){
            Set<String> set = new HashSet<>();
            List<Pair> list = map.get(key);
            Collections.sort(list, (a,b) -> a.time - b.time);
            for(int i = 0 ; i < list.size() -2 ; i++){
                for(int j = i+1 ; j < list.size() -1 ; j++){
                    for(int k = j+1; k < list.size(); k++){
                        String str = list.get(i).web + " " + list.get(j).web + " " + list.get(k).web;
                        if(!set.contains(str)){
                            count.put(str, count.getOrDefault(str, 0) + 1);
                            set.add(str);
                        }
                        
                        if(res.equals("") || count.get(res) < count.get(str) || 
                          count.get(res) == count.get(str) && res.compareTo(str) > 0){
                            res = str;
                        }
                        
                    }
                }
            }
            
        }
        return Arrays.asList(res.split(" "));
    }
}