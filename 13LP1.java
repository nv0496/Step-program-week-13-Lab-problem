// Lab Problem 1: Insert Node at a Given Position in Singly Linked List

import java.util.Scanner;

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

    // Insert node at the end (for creating initial list)
    public void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Insert node at a specific position
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);

        // Case 1: Insert at the beginning
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        int count = 1;

        // Traverse to the node before the insertion point
        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        // Invalid position check
        if (temp == null) {
            System.out.println("Invalid position! List has fewer nodes.");
            return;
        }

        // Insert the new node
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Display the linked list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null)
                System.out.print(" → ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class InsertAtPosition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        // Create a sample list
        list.insertEnd(10);
        list.insertEnd(20);
        list.insertEnd(30);
        list.insertEnd(40);

        System.out.print("Original List: ");
        list.display();

        // Get user input
        System.out.print("Enter data to insert: ");
        int data = sc.nextInt();

        System.out.print("Enter position to insert: ");
        int position = sc.nextInt();

        // Insert and display updated list
        list.insertAtPosition(data, position);

        System.out.print("Updated List: ");
        list.display();

        sc.close();
    }
}
