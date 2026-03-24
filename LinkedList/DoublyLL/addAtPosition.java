public class AddAtPosition {
    static class Node {
        int data;
        Node next, prev;
        Node(int data) { this.data = data; }
    }

    static Node head, tail;
    static int size = 0;

    public static void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) { head = tail = newNode; }
        else { tail.next = newNode; newNode.prev = tail; tail = newNode; }
        size++;
    }

    // Add at Given Position (1-indexed) - O(n)
    public static void addAtPosition(int data, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position!");
            return;
        }

        // reuse addFirst if position is 1
        if (position == 1) {
            Node newNode = new Node(data);
            newNode.next = head;
            if (head != null) head.prev = newNode;
            head = newNode;
            if (tail == null) tail = head;
            size++;
            return;
        }

        // reuse addLast if position is last
        if (position == size + 1) {
            addLast(data);
            return;
        }

        // middle insertion
        Node newNode = new Node(data);
        Node curr = head;

        for (int i = 1; i < position - 1; i++) {
            curr = curr.next;  // reach node just before position
        }

        Node nextNode    = curr.next;
        curr.next        = newNode;   // curr    → newNode
        newNode.prev     = curr;      // curr    ← newNode
        newNode.next     = nextNode;  // newNode → nextNode
        nextNode.prev    = newNode;   // newNode ← nextNode
        size++;
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
        addLast(1); addLast(2); addLast(4);
        System.out.print("Before : "); printForward();

        addAtPosition(3, 3);   // insert 3 at position 3
        System.out.print("After inserting 3 at pos 3 : "); printForward();

        addAtPosition(0, 1);   // insert 0 at beginning
        System.out.print("After inserting 0 at pos 1 : "); printForward();

        addAtPosition(5, 6);   // insert 5 at end
        System.out.print("After inserting 5 at pos 6 : "); printForward();
    }
}
