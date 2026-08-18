class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        // Step 1: Insert copy after every original node
        Node ptr = head;

        while (ptr != null) {
            Node copy = new Node(ptr.val);

            copy.next = ptr.next;
            ptr.next = copy;

            // Move to next ORIGINAL node
            ptr = copy.next;
        }

        // Step 2: Set random pointers
        ptr = head;

        while (ptr != null) {
            Node copy = ptr.next;

            if (ptr.random != null) {
                copy.random = ptr.random.next;
            }

            // Move to next ORIGINAL node
            ptr = copy.next;
        }

        // Step 3: Separate original and copied lists
        Node newHead = head.next;
        ptr = head;

        while (ptr != null) {
            Node copy = ptr.next;

            // Restore original list
            ptr.next = copy.next;

            // Connect copied list
            if (copy.next != null) {
                copy.next = copy.next.next;
            }

            ptr = ptr.next;
        }

        return newHead;
    }
}