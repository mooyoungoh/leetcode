class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> list;
    int size;
    Random r;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        size = 0;
        r = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, size++);
        list.add(val);
        return true;        
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index = map.get(val);
        map.remove(val);
        if(index != list.size() - 1){
            int swap = list.get(size - 1);
            list.set(index, swap);
            map.put(swap, index);
        }
        list.remove(--size);
        return true;
    }
    
    public int getRandom() {
        int index = r.nextInt(size);        
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */