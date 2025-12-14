import java.util.*;

public class Stack{
  
  public static void pushAtBottom(Stack<Integer> s,int data){
    if(s.isEmpty()){
      s.push(data);
      return;
    }

    int top = s.pop();
    PushAtBottom(s,data);
    s.push(data);
  }
  
  public static void reverseStack(Stack<Integer> s){
    if(s.isEmpty()){
      return;
    }
    int top = s.pop();
    reverseStack(s);
    pushAtBottom(s,top);
  }
  
  public static void printStack(Stack<Integer> s){
    while(!s.isEmpty()){
      System.out.println(s.pop());
    }
  }
  
  // public static void main(String args[]){
  //   Stack<Integer> s = new Stack<>();
  //   s.push(2);
  //   s.push(4);
  //   s.push(6);
  //   s.push(8);
  //   reverseStack(s);
  //   printStack(s);
  // }
}
