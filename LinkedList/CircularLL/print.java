public class CLLPrint {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static Node head = null;
    static Node tail = null;

    public static void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) { head = tail = newNode; newNode.next = head; }
        else { tail.next = newNode; tail = newNode; tail.next = head; }
    }

    // Print Circular List - O(n)
    // Must use do-while because head is also revisited at end
    public static void printList() {
        if (head == null) { System.out.println("List is empty!"); return; }

        Node temp = head;
        System.out.print("List: ");
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head: " + head.data + ")");
    }

    public static void main(String[] args) {
        addLast(1); addLast(2); addLast(3); addLast(4); addLast(5);
        printList();
    }
}
