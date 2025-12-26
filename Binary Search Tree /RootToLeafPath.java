import java.util.*;

public class RootToLeafPath {
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
  
  public static void printPath(ArrayList<Integer> path) {
    for (int i = 0; i < path.size(); i++) {
      System.out.print(path.get(i) + " -> ");
    }
    System.out.println("null");
  }
  
  public static void printRootToLeaf(Node root, ArrayList<Integer> path) {
    if (root == null) {
      return;
    }
    path.add(root.data);
    
    if (root.left == null && root.right == null) {
      printPath(path);
    }else {
      printRootToLeaf(root.left, path);
      printRootToLeaf(root.right, path);
    }
  
    path.remove(path.size() - 1);
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
  
  // public static void main(String args[]) {
  //   int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
  //   Node root = null;
  //   for (int val : values) {
  //     root = insert(root, val);
  //   }
  //   printRootToLeaf(root, new ArrayList<>());
  // }
}
