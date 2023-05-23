class LRUCache {
    
    public class CacheItem{
        int key;
        int value;
        public CacheItem(int key, int value){
            this.key = key;
            this.value = value;
        }
        CacheItem prev;
        CacheItem next;
    }
    
    CacheItem head;
    CacheItem tail;
    Map<Integer, CacheItem> map;
    int capacity;

    public LRUCache(int capacity) {
        head = null;
        tail = null;
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        CacheItem cur = map.get(key);
        if(cur != head){
            if(cur == tail){
                tail = tail.prev;
            }
            // head - cur.prev - cur - cur.next
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
            //insert
            CacheItem cur = new CacheItem(key, value);
            if(head == null){
                head = cur;
                tail = cur;
            }else{
                head.prev = cur;
                cur.next = head;
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