public class DetectLoop {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

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

    public boolean detectLoop() {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        DetectLoop list = new DetectLoop();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        // create loop
        list.head.next.next.next.next = list.head.next;

        System.out.println("Loop detected: " + list.detectLoop());
    }
}
