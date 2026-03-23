public class ZigZagLinkedList {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public static Node zigZag(Node head) {
        if (head == null || head.next == null) return head;

        // ── STEP 1: Find middle using slow/fast pointer ──────────────
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow is now at middle

        // ── STEP 2: Reverse second half ───────────────────────────────
        Node secondHalf = reverse(slow.next);
        slow.next = null; // cut into two halves

        // ── STEP 3: Merge using two pointers alternately ─────────────
        Node first  = head;       // pointer 1 → starts at front
        Node second = secondHalf; // pointer 2 → starts at back

        Node dummy = new Node(0);
        Node curr  = dummy;

        boolean pickFirst = true; // alternate between first and second

        while (first != null && second != null) {
            if (pickFirst) {
                curr.next = first;
                first = first.next;
            } else {
                curr.next = second;
                second = second.next;
            }
            curr = curr.next;
            pickFirst = !pickFirst; // flip after every pick
        }

        // attach remaining nodes if any
        while (first != null) {
            curr.next = first;
            first = first.next;
            curr = curr.next;
        }
        while (second != null) {
            curr.next = second;
            second = second.next;
            curr = curr.next;
        }

        curr.next = null;
        return dummy.next;
    }

    // Helper: reverse a linked list
    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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

        // Test 1: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        System.out.print("Test1 Before : ");
        printList(head1);
        head1 = zigZag(head1);
        System.out.print("Test1 After  : ");
        printList(head1);
    }
}
