public class RemoveFirst {

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

    public int removeFirst() {

        if (head == null) {
            System.out.println("List is empty");
            return -1;
        }

        int val = head.data;
        head = head.next;
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
        RemoveFirst list = new RemoveFirst();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        list.removeFirst();

        list.print();
    }
}
