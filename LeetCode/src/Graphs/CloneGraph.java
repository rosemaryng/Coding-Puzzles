package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
  class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }

    private HashMap<Node, Node> visited = new HashMap <> (); //Key: actual, value: cloned
    public Node cloneGraph(Node node) {
      if (node == null) {
        return null;
      }
      // If the node was already visited before, return the clone from the visited dictionary.
      if (visited.containsKey(node)) return visited.get(node);
      Node cloneNode = new Node(node.val, new ArrayList()); //Create clone
      visited.put(node, cloneNode);
      for (Node neighbor: node.neighbors) { //populate neighbours
        cloneNode.neighbors.add(cloneGraph(neighbor));
      }
      return cloneNode;
    }

  }
}
