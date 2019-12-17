package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traversals {
  public void traversePreOrder(List<TreeNode> list, TreeNode root) {
    if (root == null) return;
    list.add(root);
    traversePreOrder(list, root.left);
    traversePreOrder(list, root.right);

  }

  public List<TreeNode> bfs(TreeNode root) {
    if (root == null) return null;
    List<TreeNode> res = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      TreeNode curr = q.poll();
      res.add(curr);
      if (curr.left != null) q.add(curr.left);
      if (curr.right != null) q.add(curr.right);
    }
    return res;
  }

  public List<List<Integer>> bfsR(TreeNode root) {
    if (root == null) return null;
    List<List<Integer>> res = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      List<Integer> subList = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode curr = q.poll();
        subList.add(curr.val);
        if (curr.left != null) q.add(curr.left);
        if (curr.right != null) q.add(curr.right);
      }
      res.add(subList);
    }
    return res;
  }
}
