class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    HashMap<Integer, Node> map;
    Node head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node currNode = map.get(key);
            remove(currNode);
        }
        Node node = new Node(key, value);
        map.put(key, node);
        add(node);

        if(map.size() > capacity) {
            Node leastUsed = head.next;
            remove(leastUsed);
            map.remove(leastUsed.key);
        }
    }

    public void add(Node node) {
        Node currentEnd = tail.prev;
        currentEnd.next = node;
        node.prev = currentEnd;
        node.next = tail;
        tail.prev = node;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */