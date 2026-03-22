public class SegregateEvenOdd {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    // Maintain two separate lists (even & odd) then join them
    public static Node segregate(Node head) {
        if (head == null || head.next == null) return head;

        Node evenHead = null, evenTail = null;
        Node oddHead  = null, oddTail  = null;

        Node current = head;

        while (current != null) {
            int val = current.data;

            if (val % 2 == 0) {
                // append to even list
                if (evenHead == null) {
                    evenHead = current;
                    evenTail = evenHead;
                } else {
                    evenTail.next = current;
                    evenTail = evenTail.next;
                }
            } else {
                // append to odd list
                if (oddHead == null) {
                    oddHead = current;
                    oddTail = oddHead;
                } else {
                    oddTail.next = current;
                    oddTail = oddTail.next;
                }
            }
            current = current.next;
        }

        // If no even numbers exist, return odd list
        if (evenHead == null) return oddHead;

        // Join even list -> odd list
        evenTail.next = oddHead;

        //terminate the odd list to avoid cycle
        if (oddTail != null) oddTail.next = null;

        return evenHead;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        System.out.print("Before : ");
        printList(head);
        head = segregate(head);
        System.out.print("After  : ");
        printList(head);
    }
}
