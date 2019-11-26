package BinaryTrees;

import java.util.LinkedList;
import java.util.List;

public class Traversals {
  public void traversePreOrder(List<TreeNode> list, TreeNode root) {
    if (root == null) return;
    list.add(root);
    traversePreOrder(list, root.left);
    traversePreOrder(list, root.right);

  }

}
