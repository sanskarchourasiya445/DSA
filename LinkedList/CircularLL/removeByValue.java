public class CLL_RemoveByValue {
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

    // Remove by Value - O(n)
    public static void removeByValue(int data) {
        if (head == null) { System.out.println("List is empty!"); return; }

        // removing head
        if (head.data == data) {
            if (head == tail) { head = tail = null; return; }
            head = head.next;
            tail.next = head;
            return;
        }

        Node curr = head;
        while (curr.next != head) {
            if (curr.next.data == data) {
                if (curr.next == tail) tail = curr; // update tail if needed
                curr.next = curr.next.next;          // bypass node
                return;
            }
            curr = curr.next;
        }
        System.out.println(data + " not found!");
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
        addLast(1); addLast(2); addLast(3); addLast(4); addLast(5);
        System.out.print("Before             : "); printList();

        removeByValue(3);
        System.out.print("After removing 3   : "); printList();

        removeByValue(1);
        System.out.print("After removing 1   : "); printList();

        removeByValue(5);
        System.out.print("After removing 5   : "); printList();

        removeByValue(99);
    }
}
