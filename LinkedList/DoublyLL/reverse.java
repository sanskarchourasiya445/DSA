public class ReverseDLL {

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
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Reverse using curr, prev, next pointers
    // O(n) time | O(1) space
    public static void reverse() {
        if (head == null || head.next == null) return;

        Node curr = head;  // start at head
        Node prev = null;  // nothing before head
        Node next = null;  // will hold next node temporarily

        while (curr != null) {
            next = curr.next;  // save next before we lose it
            curr.next = prev;  // flip → now points backward
            curr.prev = next;  // flip ← now points forward
            prev = curr;       // prev moves to current
            curr = next;       // curr moves to next
        }

        // prev is now sitting at old tail = new head
        tail = head;
        head = prev;
    }

    public static void printForward() {
        Node temp = head;
        System.out.print("Forward : null <-> ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void printBackward() {
        Node temp = tail;
        System.out.print("Backward: null <-> ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        addLast(1);
        addLast(2); 
        addLast(3); 
        addLast(4); 
        addLast(5);

        System.out.print("Before  : "); printForward();
        System.out.print("          "); printBackward();

        reverse();

        System.out.println();
        System.out.print("After   : "); printForward();
        System.out.print("          "); printBackward();
    }
}
