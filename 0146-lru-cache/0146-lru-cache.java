class LRUCache {

    public class cacheItem{
        int key;
        int value;
        cacheItem prev;
        cacheItem next;
        public cacheItem(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    cacheItem head;
    cacheItem tail;
    int capacity;
    Map<Integer, cacheItem> map;

    public LRUCache(int capacity) {
        head = null;
        tail = null;
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        
        cacheItem cur = map.get(key);
        if(cur != head){
            if(cur == tail){
                tail = tail.prev;
            }
            // cur.prev - cur - cur.next
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
            cacheItem cur = new cacheItem(key, value);
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