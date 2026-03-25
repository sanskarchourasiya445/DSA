public class CLL_AddLast {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static Node head = null;
    static Node tail = null;

    // Add at End - O(1)
    public static void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            newNode.next = head;  // points to itself
        } else {
            tail.next = newNode;  // old tail → newNode
            tail = newNode;       // tail = newNode
            tail.next = head;     // new tail → head (maintain circle)
        }
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
        addLast(1); printList();
        addLast(2); printList();
        addLast(3); printList();
    }
}
