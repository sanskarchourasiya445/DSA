public class Search {
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

    // Search by Value - O(n)
    public static boolean search(int data) {
        Node curr = head;
        int position = 1;

        while (curr != null) {
            if (curr.data == data) {
                System.out.println(data + " found at position " + position);
                return true;
            }
            curr = curr.next;
            position++;
        }
        System.out.println(data + " not found!");
        return false;
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
        addLast(10); addLast(20); addLast(30); addLast(40); addLast(50);
        printForward();

        search(30);   // middle
        search(10);   // head
        search(50);   // tail
        search(99);   // not found
    }
}
