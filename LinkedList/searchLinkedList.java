public class SearchLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // Add element at end
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

    // Iterative Search
    public int itrSearch(int key) {
        Node temp = head;
        int index = 0;

        while (temp != null) {

            if (temp.data == key) {
                return index;
            }

            temp = temp.next;
            index++;
        }

        return -1;
    }

    // Recursive Search Helper
    private int recSearch(Node head, int key) {

        if (head == null) {
            return -1;
        }

        if (head.data == key) {
            return 0;
        }

        int idx = recSearch(head.next, key);

        if (idx == -1) {
            return -1;
        }

        return idx + 1;
    }

    // Wrapper function
    public int search(int key) {
        return recSearch(head, key);
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

        SearchLinkedList list = new SearchLinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        list.print();

        System.out.println("Iterative Search (20): " + list.itrSearch(20));
        System.out.println("Recursive Search (30): " + list.search(30));
    }
}
