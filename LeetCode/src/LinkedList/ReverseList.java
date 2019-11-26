package LinkedList;

public class ReverseList {
  public static ListNode reverseList(ListNode head) {
    ListNode curr = head, prev = null;
    while (curr != null) {
      ListNode originalNext = curr.next;
      curr.next = prev;
      prev = curr;
      curr = originalNext;
    }
    return prev;
  }

  public ListNode reverseListRecurse(ListNode head) {
    return reverseListRecurseHelper(head, null);
  }

  private ListNode reverseListRecurseHelper(ListNode head, ListNode prev) {
    ListNode next = head.next;
    head.next = prev;
    if (next == null) {
      return head;
    }
    return reverseListRecurseHelper(next, head);

  }

  public static ListNode reverseBetween(ListNode head, int m, int n) {
    if (head == null || m == n) return head;

    // Move the two pointers until they reach the proper starting point
    // in the list.
    ListNode cur = head, prev = null;
    while (m > 1) {
      prev = cur;
      cur = cur.next;
      m--;
      n--;
    }
    ListNode con = prev, tail = cur; // The two pointers that will fix the final connections.

    ListNode originalNext = null; // Iteratively reverse the nodes until n becomes 0.
    while (n > 0) {
      originalNext = cur.next;
      cur.next = prev;
      prev = cur;
      cur = originalNext;
      n--;
    }

    // Adjust the final connections as explained in the algorithm
    if (con != null) {
      con.next = prev;
    } else {
      head = prev;
    }

    tail.next = cur;
    return head;
  }



  public static void main(String[] args) {
    ListNode a = new ListNode(1);
    ListNode b = new ListNode(2);
    ListNode c = new ListNode(7);
    ListNode d = new ListNode(4);
    ListNode e = new ListNode(2);
    //ListNode f = new ListNode(3);
    a.next = b;
    b.next = c;
    c.next = d;
    d.next = e;
    System.out.println("answer: " + reverseBetween(a, 1, 2));
  }

}
