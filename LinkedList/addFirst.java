public class AddFirst {

    Node head;

    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
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
        AddFirst list = new AddFirst();

        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);

        list.print();
    }
}
