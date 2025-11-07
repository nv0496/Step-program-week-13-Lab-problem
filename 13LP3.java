// Lab Problem 3: Delete all occurrences of a specific value in a Doubly Linked List

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
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
        newNode.prev = temp;
    }

    // Delete all occurrences of a specific value
    public void deleteAll(int value) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == value) {
                // Case 1: Deleting head node
                if (temp.prev == null) {
                    head = temp.next;
                    if (head != null)
                        head.prev = null;
