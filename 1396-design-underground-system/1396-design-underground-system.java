class UndergroundSystem {
    
    Map<Integer, Pair<String, Integer>> checkIn = new HashMap<>();
    Map<String, Pair<Double, Integer>> route = new HashMap<>();

    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIn.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> cur = checkIn.get(id);
        String routeName = cur.getKey() + "_" + stationName;
        int totalTime = t - cur.getValue();
        
        Pair<Double, Integer> rou = route.getOrDefault(routeName, new Pair(0.0, 0));
        route.put(routeName, new Pair<>(rou.getKey() + totalTime, rou.getValue() + 1));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeName = startStation + "_" + endStation;
        Pair<Double, Integer> cur = route.get(routeName);
        return cur.getKey() / cur.getValue();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */