// Lab Problem 4: Sort a Doubly Linked List in Ascending Order using Bubble Sort

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

    // Bubble Sort algorithm to sort the doubly linked list
    public void bubbleSort() {
        if (head == null)
            return;

        boolean swapped;
        Node current;

        do {
            swapped = false;
            current = head;

            while (current.next != null) {
                if (current.data > current.next.data) {
                    // Swap data between adjacent nodes
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped); // Repeat until no swaps occur
    }

    // Display the list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null)
                System.out.print(" ⇄ ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class SortDoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Create a sample unsorted list
        list.insert(40);
        list.insert(10);
        list.insert(30);
        list.insert(20);

        System.out.print("Original List: ");
        list.display();

        // Sort the list using Bubble Sort
        list.bubbleSort();

        System.out.print("Sorted List (Ascending Order): ");
        list.display();
    }
}
