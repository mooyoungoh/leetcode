class LFUCache {
 private int capacity;
    private Map<Integer, Node> keyToNode;
    private Map<Integer, LinkedList<Node>> freqToNodes;
    private int minFreq;

    class Node {
        int key;
        int value;
        int frequency;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.keyToNode = new HashMap<>();
        this.freqToNodes = new HashMap<>();
        this.minFreq = 0;
    }

    private void updateFrequency(Node node) {
        LinkedList<Node> nodes = freqToNodes.get(node.frequency);
        nodes.remove(node);

        if (node.frequency == minFreq && nodes.isEmpty()) {
            minFreq++;
        }

        node.frequency++;
        freqToNodes.putIfAbsent(node.frequency, new LinkedList<>());
        freqToNodes.get(node.frequency).addFirst(node);
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }

        Node node = keyToNode.get(key);
        updateFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.value = value;
            updateFrequency(node);
            return;
        }

        if (keyToNode.size() >= capacity) {
            LinkedList<Node> minFreqNodes = freqToNodes.get(minFreq);
            Node evictNode = minFreqNodes.removeLast();
            keyToNode.remove(evictNode.key);
        }

        Node newNode = new Node(key, value);
        keyToNode.put(key, newNode);
        freqToNodes.putIfAbsent(1, new LinkedList<>());
        freqToNodes.get(1).addFirst(newNode);
        minFreq = 1;
    }
}