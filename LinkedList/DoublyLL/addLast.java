public class AddLast {
    static class Node {
        int data;
        Node next, prev;
        Node(int data) { this.data = data; }
    }

    static Node head, tail;

    // Add at End - O(1)
    public static void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;  // old tail → newNode
            newNode.prev = tail;  // newNode ← old tail
            tail = newNode;       // tail = newNode
        }
    }

    public static void printForward() {
        Node temp = head;
        System.out.print("List: null <-> ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        addLast(1);
        printForward();          // null <-> 1 <-> null

        addLast(2);
        printForward();          // null <-> 1 <-> 2 <-> null

        addLast(3);
        printForward();          // null <-> 1 <-> 2 <-> 3 <-> null
    }
}
