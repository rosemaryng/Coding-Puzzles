package LinkedList;

public class IntersectionOfTwoLists {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //boundary check
    if (headA == null || headB == null) return null;
    ListNode a = headA;
    ListNode b = headB;
    //if a & b have different len, then we will stop the loop after second iteration
    while (a != b) {
      //for the end of first iteration, we just reset the pointer to the head of another linkedlist
      a = a == null ? headB : a.next;
      b = b == null ? headA : b.next;
      // With 2 iterations, they would have got to the same length!!!!
    }
    return a;
  }

  public ListNode getIntersectionNodeCount(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null) return null;
    // step 1. count the two lists
    int n1 = count(l1), n2 = count(l2);

    // step 2. move the longer one |n1 - n2| steps
    int n = Math.abs(n1 - n2);
    while (n-- > 0) {
      if (n1 > n2)
        l1 = l1.next;
      else
        l2 = l2.next;
    }

    // step 3. move together and find the meeting point
    while (l1 != l2) {
      l1 = l1.next;
      l2 = l2.next;
    }

    return l1;
  }

  int count(ListNode l) {
    int n = 0;
    while (l != null) {
      n++;
      l = l.next;
    }
    return n;
  }


}
