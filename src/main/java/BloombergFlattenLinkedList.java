//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
public class BloombergFlattenLinkedList {
    private Node tail;

    public Node flatten(Node head) {
        if (head == null) return head;

        head.prev = tail;
        tail = head;

        Node nextNode = head.next;

        head.next = flatten(head.child);
        head.child = null;

        tail.next = flatten(nextNode);

        return head;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}