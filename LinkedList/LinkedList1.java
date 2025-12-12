public class LinkedList1 {
  public static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static Node head;
  public static Node tail;
  public static int size;

  public void addFirst(int data) {
    Node newNode = new Node(data);
    size++;
    if (head == null) {
      head = tail = newNode;
      return;
    }
    newNode.next = head;
    head = newNode;
  }

  public void addLast(int data) {
    Node newNode = new Node(data);
    size++;
    if (head == null) {
      head = tail = newNode;
      return;
    }
    tail.next = newNode;
    tail = newNode;
  }

  public void addMiddle(int index, int data) {

    if (index == 0) {
      addFirst(data);
      return;
    }
    Node newNode = new Node(data);
    size++;

    int i = 0;
    Node temp = head;

    while (i < index - 1) {

      temp = temp.next;
      i = i + 1;
    }

    newNode.next = temp.next;
    temp.next = newNode;
  }

  public int removeFirst() {

    if (size == 0) {
      System.out.println("Linked list is empty");
      return Integer.MIN_VALUE;
    }

    if (size == 1) {
      int val = head.data;
      head = tail = null;
      size--;

      return val;
    }

    int val = head.data;
    head = head.next;
    size--;
    return val;
  }

  public int removeLast() {
    int val = tail.data;

    if (size == 0) {
      System.out.println("Linked List is empty");
      return Integer.MIN_VALUE;
    }

    if (size == 1) {

      head = tail = null;
      size--;
      return val;
    }

    Node temp = head;
    for (int i = 0; i < size - 2; i++) {
      temp = head.next;
    }

    temp.next.next = null;
    tail = temp;
    size--;
    return val;

  }

  public void print() {
    if (head == null) {
      System.out.println("List is empty");
      return;
    }

    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + "->");
      temp = temp.next;
    }
    System.out.println("null");
  }

 

