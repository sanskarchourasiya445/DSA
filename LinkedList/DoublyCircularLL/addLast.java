public class DCLL_AddLast {
    static class Node {
        int data;
        Node next, prev;
        Node(int data) { this.data = data; }
    }

    static Node head = null;
    static Node tail = null;

    // Add at End - O(1)
    public static void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
            newNode.prev = head;
        } else {
            tail.next = newNode;  // old tail → newNode
            newNode.prev = tail;  // newNode ← old tail
            newNode.next = head;  // newNode → head (maintain circle)
            head.prev = newNode;  // head ← newNode
            tail = newNode;       // tail = newNode
        }
    }

    public static void printForward() {
        if (head == null) { System.out.println("List is empty!"); return; }
        Node temp = head;
        System.out.print("Forward: ");
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to " + head.data + ")");
    }

    public static void printBackward() {
        if (tail == null) { System.out.println("List is empty!"); return; }
        Node temp = tail;
        System.out.print("Backward: ");
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        } while (temp != tail);
        System.out.println("(back to " + tail.data + ")");
    }

    public static void main(String[] args) {
        addLast(1); printForward();
        addLast(2); printForward();
        addLast(3); printForward();
        System.out.println();
        printBackward();
    }
}
