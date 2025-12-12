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
