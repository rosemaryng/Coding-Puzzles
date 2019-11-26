package Graphs;

public class FlattenMultiLevelLinkedList {
  public Node flatten(Node next, Node head) {
    return flattenRecurse(head, null);
//    return head;
  }

  private Node flattenRecurse(Node curr, Node tail) {
    if (curr == null) return tail;
    Node originalNext = flatten(curr.next, tail);
    Node child = flatten(curr.child, originalNext);
    curr.next = child;
    if (child != null) child.prev = curr;
    curr.child = null;
    return curr;
//    if (curr.child != null) {
//      Node originalNext = curr.next;
//      curr.next = curr.child;
//      curr = curr.next;
//      flattenRecurse(curr, originalNext);
//    }else if (curr.next != null) {
//      curr = curr.next;
//      flattenRecurse(curr, tail);
//    }else {
//      curr.next = tail;
//      curr = curr.next;
//      flattenRecurse(curr, null);
//    }
  }

  public Node flatten2(Node head) {
    if (head == null) return null;
    if (head.child != null) {
      Node next = head.next;
      head.child.prev = head;
      head.next = flatten2(head.child);
      Node last = head;
      while (last.next != null) last = last.next;
      if (next != null) next.prev = last;
      last.next = flatten2(next);
      head.child = null;
    } else
      head.next = flatten2(head.next);
    return head;
  }

  class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int _val, Node _prev, Node _next, Node _child) {
      val = _val;
      prev = _prev;
      next = _next;
      child = _child;
    }
  }
}
