public class RemoveLast {

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

    public int removeLast() {

        if (head == null) {
            System.out.println("List is empty");
            return -1;
        }

        if (head.next == null) {
            int val = head.data;
            head = null;
            return val;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        int val = temp.next.data;
        temp.next = null;

        return val;
    }

    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        RemoveLast list = new RemoveLast();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        list.removeLast();

        list.print();
    }
}
