public class RemoveByValue {
    static class Node {
        int data;
        Node next, prev;
        Node(int data) { this.data = data; }
    }

    static Node head, tail;

    public static void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) { head = tail = newNode; }
        else { tail.next = newNode; newNode.prev = tail; tail = newNode; }
    }

    // Remove by Value - O(n)
    public static void removeByValue(int data) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node curr = head;
        while (curr != null) {
            if (curr.data == data) {

                if (curr == head) {
                    // removing head
                    head = head.next;
                    if (head != null) head.prev = null;
                    else tail = null;
                    return;
                }

                if (curr == tail) {
                    // removing tail
                    tail = tail.prev;
                    tail.next = null;
                    return;
                }

                // removing middle node
                curr.prev.next = curr.next;  // bypass forward
                curr.next.prev = curr.prev;  // bypass backward
                return;
            }
            curr = curr.next;
        }
        System.out.println(data + " not found!");
    }

    public static void printForward() {
        Node temp = head;
        System.out.print("List: null <-> ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        addLast(1); addLast(2); addLast(3); addLast(4); addLast(5);
        System.out.print("Before             : "); printForward();

        removeByValue(3);  // remove middle
        System.out.print("After removing 3   : "); printForward();

        removeByValue(1);  // remove head
        System.out.print("After removing 1   : "); printForward();

        removeByValue(5);  // remove tail
        System.out.print("After removing 5   : "); printForward();

        removeByValue(99); // not found
    }
}
