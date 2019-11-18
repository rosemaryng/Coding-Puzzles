package LinkedList;

public class ListNode {
  int val;
  ListNode next;

  public ListNode(int val) {
    this.val = val;
  }

  @Override
  public String toString() {
    ListNode curr = this;
    String res = "";
    while (curr.next != null) {
      res += curr.val + " -> ";
      curr = curr.next;
    }
    return res + curr.val;
  }
}
