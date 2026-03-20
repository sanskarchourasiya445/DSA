public class AddMiddle {

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

    public void addMiddle(int index, int data) {

        if (index == 0) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
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
        AddMiddle list = new AddMiddle();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        list.addMiddle(1, 15);

        list.print();
    }
}
