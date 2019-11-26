package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointer {
  public Node connect(Node root) {
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()) {
      Node currNode = q.poll();
      if (currNode != null) {
        if (currNode.right != null) {
          currNode.left.next = currNode.right;
          if (currNode.next != null) {
            currNode.right = currNode.next.left;
          }
        }
        q.add(currNode.left);
        q.add(currNode.right);
      }
    }
    return root;
  }



  public void connectRecurison(Node root) {
    if (root == null) return;

    if (root.left != null) {
      root.left.next = root.right;
    }

    if (root.right != null) {
      root.right.next = root.next != null ? root.next.left : null;
    }

    connectRecurison(root.left);
    connectRecurison(root.right);
  }

  public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }
}
