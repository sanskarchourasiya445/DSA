public class CLLAddFirst {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static Node head = null;
    static Node tail = null;

    // Add at Beginning - O(1)
    // tail.next always points back to head (circular)
    public static void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            newNode.next = head;  // points to itself
        } else {
            newNode.next = head;  // newNode → old head
            head = newNode;       // head = newNode
            tail.next = head;     // tail → new head (maintain circle)
        }
    }

    public static void printList() {
        if (head == null) { System.out.println("List is empty!"); return; }
        Node temp = head;
        System.out.print("List: ");
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to " + head.data + ")");
    }

    public static void main(String[] args) {
        addFirst(3); printList();
        addFirst(2); printList();
        addFirst(1); printList();
    }
}
