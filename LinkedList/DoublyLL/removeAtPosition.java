public class RemoveAtPosition {
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

    // Remove at Given Position (1-indexed) - O(n)
    public static void removeAtPosition(int position) {
        if (position < 1 || position > size) {
            System.out.println("Invalid position!");
            return;
        }

        if (position == 1) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
            size--;
            return;
        }

        if (position == size) {
            tail = tail.prev;
            tail.next = null;
            size--;
            return;
        }

        Node curr = head;
        for (int i = 1; i < position; i++) {
            curr = curr.next;  // reach node at position
        }

        curr.prev.next = curr.next;  // bypass forward
        curr.next.prev = curr.prev;  // bypass backward
        size--;
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
        addLast(1); addLast(2); addLast(3); addLast(4); addLast(5);
        System.out.print("Before              : "); printForward();

        removeAtPosition(3);  // remove middle
        System.out.print("After removePos(3)  : "); printForward();

        removeAtPosition(1);  // remove head
        System.out.print("After removePos(1)  : "); printForward();

        removeAtPosition(3);  // remove tail
        System.out.print("After removePos(3)  : "); printForward();
    }
}
