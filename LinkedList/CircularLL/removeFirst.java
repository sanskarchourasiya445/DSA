public class CLL_RemoveFirst {
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

    // Remove from Beginning - O(1)
    public static void removeFirst() {
        if (head == null) { System.out.println("List is empty!"); return; }

        if (head == tail) {
            head = tail = null;   // only one node
        } else {
            head = head.next;     // move head forward
            tail.next = head;     // tail → new head (maintain circle)
        }
    }

    public static void printList() {
        if (head == null) { System.out.println("List: empty"); return; }
        Node temp = head;
        System.out.print("List: ");
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to " + head.data + ")");
    }

    public static void main(String[] args) {
        addLast(1); addLast(2); addLast(3);
        System.out.print("Before : "); printList();

        removeFirst();
        System.out.print("After  : "); printList();

        removeFirst();
        System.out.print("After  : "); printList();
    }
}
