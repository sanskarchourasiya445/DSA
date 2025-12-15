import java.util.*;
public class Stack{
  // next greater element in the right
  public static void main(String args[]){
    int arr[] = {6,9,0,1,3};
    Stack<Integer> s = new Stack<>();
    int nxtGrtr[] = new int[arr.length];
    
    for(int i = arr.length()-1 ; i >= 0 ; i++){
      while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
        s.pop();
      }
      
      ifs.isEmpty()){
        nxtGrtr[i] = i;
      }else{
        nxtGrtr[i] = arr[s.peek()];
      }
      s.push(i);

    }

    for(int i = 0 ; i < nxtGrtr.length ; i++){
      System.out.println(nxtGrtr[i]);
    }
    System.out.println();
    
  }
}

// next greater element in the left
    for(int i = arr.length()-1 ; i >= 0 ; i++){
      while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
        s.pop();
      }
      
      ifs.isEmpty()){
        nxtGrtr[i] = i;
      }else{
        nxtGrtr[i] = arr[s.peek()];
      }
      s.push(i);

    }

// next smaller element in the right
    for(int i = 0 ; i < arr.length(); i++){
      while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
        s.pop();
      }
      
      ifs.isEmpty()){
        nxtGrtr[i] = i;
      }else{
        nxtGrtr[i] = arr[s.peek()];
      }
      s.push(i);

    }


// next smaller element in the left   
    for(int i = 0 ; i < arr.length(); i++){
      while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
        s.pop();
      }
      
      ifs.isEmpty()){
        nxtGrtr[i] = i;
      }else{
        nxtGrtr[i] = arr[s.peek()];
      }
      s.push(i);

    }
