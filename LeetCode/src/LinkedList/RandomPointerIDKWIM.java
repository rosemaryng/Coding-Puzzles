package LinkedList;

import java.util.HashMap;

public class RandomPointerIDKWIM {
  public Node copyRandomList(Node head) {
    if (head == null) return null;
    Node curr = head;
    Node currCopy = new Node(curr.val, null, null);
    visited.put(curr, currCopy);
    while (curr != null) {
      currCopy.next = getClonedNode(curr.next);
      currCopy.random = getClonedNode(curr.random);
      curr = curr.next;
      currCopy = currCopy.next;
    }
    return visited.get(head);
  }

  private Node getClonedNode(Node node) {
    if (node != null) {
      if (visited.containsKey(node)) {
        return visited.get(node);
      } else {
        visited.put(node, new Node(node.val, null, null));
        return visited.get(node);
      }
    }
    return null;
  }

  public Node copyRandomListSol(Node head) {
    if (head == null) return null;
    Node pointer = head;
    while (pointer != null) {
      Node nodeCopy = new Node(pointer.val);
      nodeCopy.next = pointer.next;
      pointer.next = nodeCopy;
      pointer = nodeCopy.next;
    }
    pointer = head;
    while (pointer != null) { //Unweaving
      // pointer is the original node, pointer.next.random = copy of original Node
      pointer.next.random = (pointer.random != null) ? pointer.random.next:null; //random copy
      pointer = pointer.next.next;
    }
    Node old_list = head;
    Node list_copy = head.next;
    Node newHead = head.next;
    while (old_list != null) {
      old_list.next = old_list.next.next;
      list_copy.next = (list_copy.next != null) ? list_copy.next.next : null;
      old_list = old_list.next;
      list_copy = list_copy.next;
    }
    return newHead;
    }


  HashMap<Node, Node> visited = new HashMap<>();

  public Node copyRandomListRecurse(Node head) {
    if (head == null) return null;
    if (visited.containsKey(head)) {
      return visited.get(head);
    }
    Node nodeCopy = new Node(head.val, null, null);
    visited.put(head, nodeCopy);

    nodeCopy.next = copyRandomListRecurse(head.next);
    nodeCopy.random = copyRandomListRecurse(head.random);
    return nodeCopy;
  }


  class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int val) {
      this(val, null, null);
    }

    public Node(int _val, Node _next, Node _random) {
      val = _val;
      next = _next;
      random = _random;
    }
  }
}
