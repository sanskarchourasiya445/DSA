public class IntersectionPoint {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    // Key idea: when one pointer reaches end, redirect it to head of OTHER list
    // Both pointers will meet at intersection after at most m+n steps
    public static Node getIntersection(Node headA, Node headB) {
        if (headA == null || headB == null) return null;

        Node a = headA;
        Node b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a; // null if no intersection, else intersection node
    }

    public static void main(String[] args) {
        // Common part: 8 -> 10
        Node common = new Node(8);
        common.next = new Node(10);

        // List A: 3 -> 6 -> 9 -> 8 -> 10
        Node headA = new Node(3);
        headA.next = new Node(6);
        headA.next.next = new Node(9);
        headA.next.next.next = common;

        // List B: 7 -> 2 -> 8 -> 10
        Node headB = new Node(7);
        headB.next = new Node(2);
        headB.next.next = common;

        Node result = getIntersection(headA, headB);

        if (result != null) {
            System.out.println("Intersection at node with value: " + result.data);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
