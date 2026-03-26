public class CLL_RemoveLast {
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

    // Remove from End - O(n)
    // Need to traverse to find second last node
    public static void removeLast() {
        if (head == null) { System.out.println("List is empty!"); return; }

        if (head == tail) {
            head = tail = null;   // only one node
            return;
        }

        Node curr = head;
        while (curr.next != tail) {
            curr = curr.next;     // reach second last node
        }

        curr.next = head;         // second last → head (new tail)
        tail = curr;              // update tail
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

        removeLast();
        System.out.print("After  : "); printList();

        removeLast();
        System.out.print("After  : "); printList();
    }
}
