public class RemoveFirst {
    static class Node {
        int data;
        Node next, prev;
        Node(int data) { this.data = data; }
    }

    static Node head, tail;

    public static void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) { head = tail = newNode; }
        else { tail.next = newNode; newNode.prev = tail; tail = newNode; }
    }

    // Remove from Beginning - O(1)
    public static void removeFirst() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head == tail) {
            head = tail = null;   // only one node
        } else {
            head = head.next;     // move head forward
            head.prev = null;     // cut back link
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
        addLast(1); addLast(2); addLast(3);
        System.out.print("Before : "); printForward();

        removeFirst();
        System.out.print("After  : "); printForward();

        removeFirst();
        System.out.print("After  : "); printForward();
    }
}
