import java.util.LinkedList;
import java.util.Queue;

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

    public Node flatten2(Node head) {
        Node dummyHead = new Node();
        dummyHead.next = head;

        Node curr, prev = dummyHead;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);

        while (!queue.isEmpty()) {
            curr = queue.poll();
            prev.next = curr;
            curr.prev = prev;

            if (curr.next != null) queue.offer(curr.next);
            if (curr.child != null) {
                queue.offer(curr.child);
                curr.child = null;
            }

            prev = curr;
        }

        dummyHead.next.prev = null;
        return dummyHead.next;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}