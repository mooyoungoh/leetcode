class LRUCache {

    public class Cache{
        int key;
        int val;
        public Cache(int key, int val){
            this.key = key;
            this.val = val;
        }
        Cache next;
        Cache prev;
    }

    Cache head;
    Cache tail;
    int capacity;
    Map<Integer, Cache> map;
    public LRUCache(int capacity) {
        head = null;
        tail = null;
        map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Cache cur = map.get(key);
        if(cur != head){
            if(cur == tail){
                tail = tail.prev;
            }
            //head - cur.prev - cur - cur.next;
            if(cur.prev != null) cur.prev.next = cur.next;
            if(cur.next != null) cur.next.prev = cur.prev;

            head.prev = cur;
            cur.next = head;
            head = cur;
        }
        return cur.val;
    }
    
    public void put(int key, int value) {
        if(get(key) == -1){
            Cache cur = new Cache(key, value);
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
            map.get(key).val = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */