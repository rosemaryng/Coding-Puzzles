package ListAndNumbers;

public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int res = getNum(l1) + getNum(l2);
    ListNode head;
    int digits = (int) Math.floor(Math.pow(res, 0.1));
    for (int i = digits; i > 0; i++) {
      head = new ListNode(res/(10*digits));
    }
    return;
  }

  private int getNum(ListNode l) {
    int res = 0;
    int pointer = 0;
    ListNode currNode = l;
    while (currNode.next != null) {
      res = l.val * (int) Math.pow(10, pointer);
      currNode = currNode.next;
    }
    return res;
  }


  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
