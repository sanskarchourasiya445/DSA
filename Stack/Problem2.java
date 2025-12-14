import java.util.*;

public class Stack{
  public static String reverseString(String str){
    Stack<Character> s = new Stack<>();
    int i = 0;
    while(i < str.length()){
      s.push(str.charAt(i));
      i++;
    }

    StringBuilder str2 = new StringBuilder("");
    while(!s.isEmpty()){
      char curr = s.pop();
      str2.append(curr);
    }
    return str2.toString();
  }

  // public static void main(String args[]){
  //   String str = "sanskar";
  //   String reverseStr = reverseString(str);
  //   System.out.println(reverseStr);
  // }
}
