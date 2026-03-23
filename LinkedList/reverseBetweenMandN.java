public class ReverseBetween {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    // Reverse nodes between position m and n (1-indexed)
    // O(n) time, O(1) space
    public static Node reverseBetween(Node head, int m, int n) {
        if (head == null || m == n) return head;

        Node dummy = new Node(0); 
        dummy.next = head;
        Node prev = dummy;

        // Step 1: Move prev to the node just BEFORE position m
        for (int i = 1; i < m; i++) {
            prev = prev.next;
        }

        // Step 2: curr is the node AT position m (start of reversal)
        Node curr = prev.next;

        // Step 3: Reverse from m to n using repeated front-insertion
        for (int i = 0; i < n - m; i++) {
            Node nextNode = curr.next;       // save next
            curr.next = nextNode.next;       // detach nextNode
            nextNode.next = prev.next;       // nextNode points to current front
            prev.next = nextNode;            // prev points to nextNode (new front)
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
        // List: 1 -> 2 -> 3 -> 4 -> 5, reverse from pos 2 to 4
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("Before : ");
        printList(head);
        head = reverseBetween(head, 2, 4);
        System.out.print("After  : ");
        printList(head);
    }
}
