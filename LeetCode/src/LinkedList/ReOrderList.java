package LinkedList;

import java.util.Stack;

public class ReOrderList {
//  Given a singly linked list L: L0→L1→…→Ln-1→Ln,
//  reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
//
//  You may not modify the values in the list's nodes, only nodes itself may be changed.
//
//  Example 1:
//
//  Given 1->2->3->4, reorder it to 1->4->2->3.
//  Example 2:
//
//  Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

  public static void reorderList(ListNode head) {

    ListNode last = head;
    System.out.println(head);
    Stack<Integer> stack = new Stack<>();
    while (last != null) {
      stack.add(last.val);
      last = last.next;
    }
    System.out.println("stack even? " + stack.size() % 2);
    int size = stack.size();
    if (size <= 2) return;
    ListNode curr = head;
    for (int i = 0; i < size/2; i++) {
      ListNode originalNext = curr.next;
      System.out.println("original " + originalNext);
      curr.next = new ListNode(stack.pop());
      System.out.println(curr);

      curr = curr.next;
      System.out.println("curr updated " + head);
      curr.next = originalNext;
      System.out.println("curr.next:" + curr.next);
      curr = originalNext;
      System.out.println("curr:" + curr);
    }
    if (size % 2 == 0) {
      curr.next = new ListNode(stack.pop());
      System.out.println("curr:" + curr);
    } else {
      curr.next = null;
      System.out.println("curr:" + curr);
    }


  }

  public static void main(String[] args) {
    ListNode a = new ListNode(1);
    ListNode b = new ListNode(2);
    ListNode c = new ListNode(7);
    ListNode d = new ListNode(4);
//    ListNode e = new ListNode(2);
//    LinkNode f = new LinkNode(3);
    a.next = b;
    b.next = c;
    c.next = d;
//    d.next = e;
    reorderList(a);
    System.out.println(a);
  }
}
