import util.ListNode;

class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            //we save the 'next' temporarily
            ListNode nextTemp = current.next;

            //'next' value for our current should be previously saved value
            // that way it will be pointing to previous value
            current.next = prev;

            //update our previous to the current value
            prev = current;

            //restore current to its true value
            current = nextTemp;
        }

        return prev;
    }
}