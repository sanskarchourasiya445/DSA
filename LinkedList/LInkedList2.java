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
public int Search(int key){
   return recSearch(head,key);
}
