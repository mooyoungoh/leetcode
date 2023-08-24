class LRUCache {

    public class CacheItem{
        int key;
        int value;
        public CacheItem(int key, int value){
            this.key = key;
            this.value = value;
        }
        CacheItem next;
        CacheItem prev;
    }

    int capacity;
    Map<Integer, CacheItem> map;
    CacheItem head;
    CacheItem tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        CacheItem cur = map.get(key);
        if(cur != head){
            if(cur == tail){
                tail = tail.prev;
            }
            if(cur.prev != null) cur.prev.next = cur.next;
            if(cur.next != null) cur.next.prev = cur.prev;

            head.prev = cur;
            cur.next = head;
            head = cur;
        }
        return cur.value;
    }
    
    public void put(int key, int value) {
        if(get(key) == -1){
            //new
            CacheItem cur = new CacheItem(key, value);
            if(head == null){
                head = cur;
                tail = cur;
            }else{
                cur.next = head;
                head.prev = cur;
                head = cur;
            }
            map.put(key, cur);
            if(map.size() > capacity){
                map.remove(tail.key);                
                tail = tail.prev;
            }

        }else{
            //update
            map.get(key).value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */