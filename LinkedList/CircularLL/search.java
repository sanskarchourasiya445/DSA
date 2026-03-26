public class CLLSearch {
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

    // Search by Value - O(n)
    public static boolean search(int data) {
        if (head == null) { System.out.println("List is empty!"); return false; }

        Node curr = head;
        int position = 1;
        do {
            if (curr.data == data) {
                System.out.println(data + " found at position " + position);
                return true;
            }
            curr = curr.next;
            position++;
        } while (curr != head);

        System.out.println(data + " not found!");
        return false;
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
        addLast(10); addLast(20); addLast(30); addLast(40); addLast(50);
        printList();

        search(30);
        search(10);
        search(50);
        search(99);
    }
}
