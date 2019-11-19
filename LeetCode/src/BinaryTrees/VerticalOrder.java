package BinaryTrees;

import org.w3c.dom.Node;

import java.util.*;

public class VerticalOrder {
  public List<List<Integer>> verticalOrderBFS(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    Map<Integer, List<Integer>> map = new TreeMap<>();
    BFS(root, map);
    for (Integer key : map.keySet()) {
      res.add(map.get(key));
    }
    return res;
  }

  // Note: x = 0 for center (i.e. tree root)
  private void BFS(TreeNode subtree, Map<Integer, List<Integer>> map) {
    Queue<NodeLocation> queue = new LinkedList<>();
    queue.add(new NodeLocation(subtree, 0));
    while (!queue.isEmpty()) {
      NodeLocation node = queue.poll();
      int x = node.location;
      List<Integer> list;
      if (map.containsKey(x)) {
        list = map.get(x);
      } else {
        list = new ArrayList<>();
      }
      list.add(node.node.val);
      map.put(x, list);
      if (node.node.left != null) {
        queue.add(new NodeLocation(node.node.left, x - 1));
      }
      if (node.node.right != null) queue.add(new NodeLocation(node.node.right, x + 1));
    }
  }

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    // Each location is a node's x position, y position, and value
    List<NodeLocation> nodes = new ArrayList();
    dfs(root, nodes,0, 0);
    Collections.sort(nodes);

    List<List<Integer>> ans = new ArrayList();
    ans.add(new ArrayList<Integer>());

    int prev = nodes.get(0).location;

    for (NodeLocation loc: nodes) {
      // If the x value changed, it's part of a new report.
      if (loc.location != prev) {
        prev = loc.location;
        ans.add(new ArrayList<Integer>());
      }
      // We always add the node's value to the latest report.
      ans.get(ans.size() - 1).add(loc.node.val);
    }

    return ans;
  }

  public void dfs(TreeNode subtree, List<NodeLocation> locations,  int x, int y) {
    if (subtree != null) {
      locations.add(new NodeLocation(subtree, x, y));
      dfs(subtree.left, locations,x-1, y+1);
      dfs(subtree.right, locations,x+1, y+1);
    }
  }


  class NodeLocation implements Comparable<NodeLocation> {
    int location;
    int depth;
    TreeNode node;

    public NodeLocation(TreeNode node, int location) {
      this.node = node;
      this.location = location;
    }

    public NodeLocation(TreeNode node, int location, int depth) {
      this.node = node;
      this.location = location;
      this.depth = depth;
    }

    @Override
    public int compareTo(NodeLocation that) {
      if (this.location != that.location)
        return Integer.compare(this.location, that.location);
      else if (this.depth != that.depth)
        return Integer.compare(this.depth, that.depth);
      else
        return Integer.compare(this.node.val, that.node.val);    }
  }


}
