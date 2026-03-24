public class PrintForward {
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

    // Print head → tail using next pointer - O(n)
    public static void printForward() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;
        System.out.print("Forward: null <-> ");
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" <-> ");
            temp = temp.next;
        }
        System.out.println(" <-> null");
    }

    public static void main(String[] args) {
        addLast(1); addLast(2); addLast(3); addLast(4); addLast(5);
        printForward();
    }
}
