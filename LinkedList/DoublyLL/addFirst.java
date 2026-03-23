public class AddFirst {
    static class Node {
        int data;
        Node next, prev;
        Node(int data) { this.data = data; }
    }

    static Node head, tail;

    // Add at Beginning - O(1)
    public static void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;  // newNode → old head
            head.prev = newNode;  // old head ← newNode
            head = newNode;       // head = newNode
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
        addFirst(3);
        printForward();          // null <-> 3 <-> null

        addFirst(2);
        printForward();          // null <-> 2 <-> 3 <-> null

        addFirst(1);
        printForward();          // null <-> 1 <-> 2 <-> 3 <-> null
    }
}
