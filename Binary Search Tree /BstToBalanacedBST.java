import java.util.*;
public class BalanceBST {
  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
    }
  }
  
  public static Node balanceBST(Node root) {
    ArrayList<Integer> inOrder = new ArrayList<>();
    getInOrder(root, inOrder);              
    return createBST(inOrder, 0, inOrder.size() - 1);
  }
  public static Node createBST(ArrayList<Integer> inOrder, int st, int end) {
    if (st > end) {
      return null;
    }
    int mid = (st + end) / 2;
    Node root = new Node(inOrder.get(mid));
    root.left = createBST(inOrder, st, mid - 1);
    root.right = createBST(inOrder, mid + 1, end);
    return root;
  }
  public static void printPreOrder(Node root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + " "); 
    printPreOrder(root.left);          
    printPreOrder(root.right);         
  }
  
  public static Node insert(Node root, int val) {
    if (root == null) {
      return new Node(val);
    }
    if (val < root.data) {
      root.left = insert(root.left, val);
    } else {
      root.right = insert(root.right, val);
    }
    return root;
  }
  
  // public static void main(String[] args) {
  //   int[] values = {1, 2, 3, 4, 5, 6, 7};
  //   Node root = null;
  //   for (int val : values) {
  //     root = insert(root, val); 
  //   }
  //   root = balanceBST(root);
  //   printPreOrder(root);
  // }
}
