import java.util.*;

public class DeleteNode {
  static class Node {
    int data;
    Node left;
    Node right;
    
    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
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

  public static Node delete(Node root, int val) {
    if (root == null) {
      return null;
    }
    if (val < root.data) {
      root.left = delete(root.left, val);
    }else if (val > root.data) {
      root.right = delete(root.right, val);
    }else {
      if (root.left == null && root.right == null) {
        return null;
      }
      if (root.left == null) {
        return root.right;
      } 
      else if (root.right == null) {
        return root.left;
      }
      Node iS = findInOrderSuccessor(root.right);
      root.data = iS.data;
      root.right = delete(root.right, iS.data);
    }
    return root;
  }
  
  public static Node findInOrderSuccessor(Node root) {
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }
  
  public static void inOrder(Node root) {
    if (root == null) {
      return;
    }
    
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);
  }

  public static void main(String args[]) {
    int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
    Node root = null;
    
    for (int val : values) {
      root = insert(root, val);
    }
    inOrder(root);
    root = delete(root, 10);
    inOrder(root);
  }
}
