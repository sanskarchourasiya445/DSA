public class RemoveDuplicates {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    //Remove duplicates from SORTED linked list
    public static Node removeDuplicatesSorted(Node head) {
        Node current = head;

        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next; // skip duplicate
            } else {
                current = current.next;
            }
        }
        return head;
    }

    //Remove duplicates from UNSORTED linked list
    public static Node removeDuplicatesUnsorted(Node head) {
        if (head == null) return null;

        HashSet<Integer> seen = new HashSet<>();
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (seen.contains(current.data)) {
                prev.next = current.next; // remove duplicate node
            } else {
                seen.add(current.data);
                prev = current;
            }
            current = current.next;
        }
        return head;
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
        // Sorted list: 1 -> 1 -> 2 -> 3 -> 3
        Node sortedHead = new Node(1);
        sortedHead.next = new Node(1);
        sortedHead.next.next = new Node(2);
        sortedHead.next.next.next = new Node(3);
        sortedHead.next.next.next.next = new Node(3);

        System.out.print("Sorted Before : ");
        printList(sortedHead);
        sortedHead = removeDuplicatesSorted(sortedHead);
        System.out.print("Sorted After  : ");
        printList(sortedHead);

        // Unsorted list: 3 -> 1 -> 4 -> 1 -> 5 -> 3
        Node unsortedHead = new Node(3);
        unsortedHead.next = new Node(1);
        unsortedHead.next.next = new Node(4);
        unsortedHead.next.next.next = new Node(1);
        unsortedHead.next.next.next.next = new Node(5);
        unsortedHead.next.next.next.next.next = new Node(3);

        System.out.print("Unsorted Before : ");
        printList(unsortedHead);
        unsortedHead = removeDuplicatesUnsorted(unsortedHead);
        System.out.print("Unsorted After  : ");
        printList(unsortedHead);
    }
}
