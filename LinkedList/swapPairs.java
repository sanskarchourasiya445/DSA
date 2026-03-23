public class SwapPairs {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    // Swap every two adjacent nodes - O(n) time, O(1) space
    // We swap LINKS not values
    public static Node swapPairs(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            Node first  = prev.next;        // 1st node of pair
            Node second = prev.next.next;   // 2nd node of pair

            // Rewire the three pointers
            first.next  = second.next;  // first skips over second
            second.next = first;        // second points back to first
            prev.next   = second;       // prev connects to second (new front)

            prev = first; // move prev forward by 2 (first is now behind)
        }

        return dummy.next;
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
        // Even: 1 -> 2 -> 3 -> 4
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);

        System.out.print("Even Before : ");
        printList(head1);
        head1 = swapPairs(head1);
        System.out.print("Even After  : ");
        printList(head1);

        // Odd: 1 -> 2 -> 3 -> 4 -> 5  (last node stays in place)
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);

        System.out.print("Odd  Before : ");
        printList(head2);
        head2 = swapPairs(head2);
        System.out.print("Odd  After  : ");
        printList(head2);
    }
}
