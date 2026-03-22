public boolean palidrome() {
  if (head == null || head.next == null) {
    return true;
  }

  
  Node mid = findMiddle(head);

  
  Node prev = null;
  Node curr = mid;
  Node next;

  while (curr != null) {
    next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;
  }
  Node right = prev;
  Node left = head;
        

  while (right != null) {
    if (left.data != right.data) {
      return false;
    }
    left = left.next;
    right = right.next;
  }
   return true;
}
