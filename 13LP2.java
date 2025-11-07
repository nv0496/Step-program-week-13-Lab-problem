// Lab Problem 2: Detect and Remove Loop in a Singly Linked List

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    // Insert node at the end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    // Create a loop manually for testing (connect last node to a given position)
    public void createLoop(int position) {
        if (head == null)
            return;

        Node loopStartNode = head;
        Node temp = head;
        int count = 1;

        // Find the node where loop will start
        while (count < position && loopStartNode != null) {
            loopStartNode = loopStartNode.next;
            count++;
        }

        // Go to last node
        while (temp.next != null) {
            temp = temp.next;
        }

        // Create loop
        temp.next = loopStartNode;
    }

    // Detect and remove loop using Floyd’s Cycle Detection Algorithm
    public boolean detectAndRemoveLoop() {
        Node slow = head, fast = head;
        boolean loopExists = false;

        // Step 1: Detect loop
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // Loop found
                loopExists = true;
                break;
            }
        }

        // Step 2: If loop exists, remove it
        if (loopExists) {
            slow = head;

            // Case 1: Loop starts at head
            if (s
