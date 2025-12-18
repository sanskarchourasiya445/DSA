import java.util.*;

public class tree {
  static class Node {
    int data;
    Node left;
    Node right;

    public Node(int data){
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }
  public static int diameter(Node root){
    if(root == null){
      return 0;
    }
 
    int leDia = diameter(root.left);
    int lfHeight = height(root.left);
    int rgDia = diameter(root.right);
    int rgHeight = height(root.right);
    int selfDiameter = lfHeight+rgHeight+1;

    return Math.max(selfDiameter,Math.max(leDia,rgDia));
  }

  static class Info{
    int diam;
    int ht;
    
    public Info(int diam, int ht){
      this.diam = diam;
      this.ht = ht;
    }
  }
  //function to calculate diameter //T.C = O(n)
  public static Info diameter2(Node root){
    if(root == null){
      return new Info(0,0);
    }

    Info leftInfo = diameter2(root.left);
    Info rightInfo = diameter2(root.right);

    int diam = Math.max(leftInfo.ht+rightInfo.ht+1,Math.max(leftInfo.diam,rightInfo.diam));
    int ht = Math.max(leftInfo.ht,rightInfo.ht)+1;

    return new Info(diam,ht);
  }

  public static void main(String args[]){
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    System.out.println("Diameter of tree is = "+diameter(root));
    System.out.println("Diameter of tree optimized way is = "+diameter2(root).diam);
  }
}
