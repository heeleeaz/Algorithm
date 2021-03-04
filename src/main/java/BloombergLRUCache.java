import java.util.HashMap;
import java.util.Map;

class BloombergLRUCache {
    private Node head;
    private Node tail;
    private int capacity;
    private int size;
    private Map<Integer, Node> map;

    public BloombergLRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            Node node = new Node();
            node.value = value;
            node.key = key;

            if (map.size() == capacity) {
                Node lastNode = tail.prev;
                map.remove(lastNode.key);
                remove(lastNode);
            }

            map.put(key, node);
            add(node);
        }
    }

    private void moveToHead(Node node) {
        remove(node);
        add(node);
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void add(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    static class Node {
        Node() {
        }

        Node prev, next;
        Integer value, key;
    }
}
