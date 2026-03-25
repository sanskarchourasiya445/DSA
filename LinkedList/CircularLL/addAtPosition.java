public class CLL_AddAtPosition {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static Node head = null;
    static Node tail = null;
    static int size = 0;

    public static void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) { head = tail = newNode; newNode.next = head; }
        else { tail.next = newNode; tail = newNode; tail.next = head; }
        size++;
    }

    // Add at Given Position (1-indexed) - O(n)
    public static void addAtPosition(int data, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position!"); return;
        }

        Node newNode = new Node(data);

        if (position == 1) {
            if (head == null) { head = tail = newNode; newNode.next = head; }
            else { newNode.next = head; head = newNode; tail.next = head; }
            size++; return;
        }

        if (position == size + 1) { addLast(data); return; }

        Node curr = head;
        for (int i = 1; i < position - 1; i++) {
            curr = curr.next;  // reach node before position
        }

        newNode.next = curr.next;  // newNode → next
        curr.next = newNode;       // curr → newNode
        size++;
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
        addLast(1); addLast(2); addLast(4);
        System.out.print("Before : "); printList();

        addAtPosition(3, 3);
        System.out.print("After inserting 3 at pos 3 : "); printList();

        addAtPosition(0, 1);
        System.out.print("After inserting 0 at pos 1 : "); printList();
    }
}
