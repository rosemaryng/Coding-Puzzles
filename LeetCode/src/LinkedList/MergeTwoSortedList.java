package LinkedList;

public class MergeTwoSortedList {
  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(-1), curr = dummyHead;
    while (l1 != null || l2 != null) {
      if (l1 == null || (l2 != null && l1.val > l2.val)) {
        curr.next = new ListNode(l2.val);
        l2 = l2.next;
      } else {
        curr.next = new ListNode(l1.val);
        l1 = l1.next;
      }
      curr = curr.next;
    }
    return dummyHead.next;
  }

  public static void main(String[] args) {
    // 1->2->3 + 3 ->2 ->1
    ListNode a = new ListNode(1);
    ListNode b = new ListNode(2);
    ListNode c = new ListNode(7);
    ListNode d = new ListNode(4);
    ListNode e = new ListNode(2);
    ListNode f = new ListNode(3);
    a.next = b;
    b.next = c;
    f.next = e;
    e.next = d;
    System.out.println("answer: " + mergeTwoLists(a, f));

  }
}
