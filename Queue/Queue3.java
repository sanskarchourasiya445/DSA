import java.util.*;

public class QueueS{
  static class Queue{
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    
    public static boolean isEmpty(){
      return stack1.isEmpty();
    }
    
    public static void add(int data){
      while(!stack1.isEmpty()){
        stack2.push(stack1.pop());
      }
      
      s1.push(data);
      
      while(!stack2.isEmpty()){
        stack1.push(stack2.pop());
      }  
    }
    
    public static int remove(){
      if(stack1.isEmpty()){
        System.out.println("Queue is Empty");
        return -1;
      }

      return s1.pop();
    }
    
    public static int peek(){
      if(stack1.isEmpty()){
        System.out.println("Queue is Empty");
        return -1;
      }

      return s1.pop();
    }
    
  }

  // public static void main(String args[]){
  //   Queue q = new Queue();
  //   q.add(1);
  //   q.add(2);
  //   q.add(3);
  //   q.add(4);

  //   while(!q.isEmpty()){
  //     System.out.println(q.peek());
  //     q.remove();
  //   }
  // }
} 

    
  
