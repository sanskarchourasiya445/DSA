public class DCLL_Print {
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

    // Print Forward - head → tail using next - O(n)
    public static void printForward() {
        if (head == null) { System.out.println("List is empty!"); return; }
        Node temp = head;
        System.out.print("Forward : ");
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to " + head.data + ")");
    }

    // Print Backward - tail → head using prev - O(n)
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
        addLast(1); addLast(2); addLast(3); addLast(4); addLast(5);
        printForward();
        printBackward();
    }
}
