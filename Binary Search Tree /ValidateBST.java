import java.util.*;

public class ValidateBST {
  static class Node {
    int data;
    Node left;
    Node right;
    
    Node(int data) {
      this.data = data;
    }
  }
  
  public static boolean isValidBST(Node root, Node min, Node max) {
    if (root == null) {
      return true;
    }
    if (min != null && root.data <= min.data) {   
      return false;
    }
    if (max != null && root.data >= max.data) {
      return false;
    }
    
    return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
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
  
  public static void inorder(Node root) {
    if (root == null) {
      return;
    }
    inorder(root.left);
    System.out.print(root.data + " ");
    inorder(root.right);
  }
  
  // public static void main(String[] args) {
  //   int[] values = {8, 5, 3, 6, 10, 11};
  //   Node root = null;
  //   for (int val : values) {
  //     root = insert(root, val);
  //   }
    
  //   inorder(root);
  //   System.out.println();
    
  //   if (isValidBST(root, null, null)) {
  //     System.out.println("This is a VALID BST");
  //   } else {
  //     System.out.println("This is NOT a valid BST");
  //   }
  // }
}
