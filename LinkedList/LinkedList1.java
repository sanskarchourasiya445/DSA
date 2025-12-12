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

  public void reverse(){
    Node prev = null;
    Node curr = tail = head;
    Node next;

    while(curr != null){
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    head = prev;
  }

  public int itrSearch(int key){
    Node temp = head;
    int i =0;

    while(temp != null){
      if(temp.data == key){
        return i;
      }

      temp = temp.next;
      i++;
    }
    return -1;
  }
// or 
  public int recSearch(Node head,int key){
    if(head == null){
      return -1;
    }
    if(head.data == key){
      return 0;
    }
    int idx = recSearch(head.next,key);
    if(idx == -1){
      return -1;
    }
    return idx + 1;
  }

  public Node getMiddle(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

public boolean detectLoop(){
  Node slow = head;
  Node fast = head;

  while(fast != null && fast.next != null){
    slow = slow.next;
    fast = fast.next.next;
    if(slow == fast){
      return true;
    }
  }  
  return false;
}


public void removeLoop(){
  Node slow = head;
  Node fast = head;
  boolean loop = false;
  while(fast != null && fast.next != null){
    slow = slow.next;
    fast = fast.next.next;
    if(slow == fast){
      loop = true;
      break;
    }
  }
  if(loop = false){
     return;
   } 
   if(loop = true){
     slow = head;
     Node prev = null;
     while(slow != fast){
       prev = fast;
       slow = slow.next;
       fast = fast.next;
     }
     prev.next = null;
   }
}

