public class RemoveLoop {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // Add node
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Detect Loop (helper)
    public boolean detectLoop() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }

    // Remove Loop 
    public void removeLoop() {

        Node slow = head;
        Node fast = head;
        boolean loop = false;

        // Step 1: detect loop
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                loop = true;
                break;
            }
        }

        if (!loop) return;
         slow = head;
        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
            return;
        }
        Node prev = null;

        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }

    // Print list
    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        RemoveLoop list = new RemoveLoop();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        // create loop
        list.head.next.next.next.next = list.head.next;

        System.out.println("Before: " + list.detectLoop());

        list.removeLoop();

        System.out.println("After: " + list.detectLoop());

        list.print();
    }
}
