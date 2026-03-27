public class DCLL_RemoveLast {
    static class Node {
        int data;
        Node next, prev;
        Node(int data) { this.data = data; }
    }

    static Node head = null;
    static Node tail = null;

    public static void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode; newNode.next = newNode.prev = head;
        } else {
            tail.next = newNode; newNode.prev = tail;
            newNode.next = head; head.prev = newNode; tail = newNode;
        }
    }

    // Remove from End - O(1)
    // Doubly circular makes this O(1) unlike singly circular
    public static void removeLast() {
        if (head == null) { System.out.println("List is empty!"); return; }

        if (head == tail) {
            head = tail = null;   // only one node
        } else {
            tail = tail.prev;     // move tail backward
            tail.next = head;     // new tail → head
            head.prev = tail;     // head ← new tail
        }
    }

    public static void printForward() {
        if (head == null) { System.out.println("List: empty"); return; }
        Node temp = head;
        System.out.print("List: ");
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to " + head.data + ")");
    }

    public static void main(String[] args) {
        addLast(1); addLast(2); addLast(3);
        System.out.print("Before : "); printForward();

        removeLast();
        System.out.print("After  : "); printForward();

        removeLast();
        System.out.print("After  : "); printForward();
    }
}
