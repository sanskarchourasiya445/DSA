public class DCLLAddFirst {
    static class Node {
        int data;
        Node next, prev;
        Node(int data) { this.data = data; }
    }

    static Node head = null;
    static Node tail = null;

    // Add at Beginning - O(1)
    public static void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            newNode.next = head;  // points to itself forward
            newNode.prev = head;  // points to itself backward
        } else {
            newNode.next = head;  // newNode → old head
            newNode.prev = tail;  // newNode ← tail
            head.prev = newNode;  // old head ← newNode
            tail.next = newNode;  // tail → newNode (maintain circle)
            head = newNode;       // head = newNode
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

    public static void main(String[] args) {
        addFirst(3); printForward();
        addFirst(2); printForward();
        addFirst(1); printForward();
    }
}
