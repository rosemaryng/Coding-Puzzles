package LinkedList;

import java.util.LinkedList;
import java.util.Queue;

public class OddEvenLinkedList {
  public ListNode oddEvenList(ListNode head) {
    ListNode curr = head;
    Queue<ListNode> oddQueue = new LinkedList<>();
    Queue<ListNode> evenQueue = new LinkedList<>();
    for (int i = 0; curr != null ; i++) {
      if (i % 2 == 0) oddQueue.add(curr);
      else evenQueue.add((curr));

      curr = curr.next;
    }
    ListNode prev = new ListNode(-1); // dummy node
    while (!oddQueue.isEmpty()) {
      curr = oddQueue.poll();
      prev.next = curr;
      prev = curr;
    }
    while (!evenQueue.isEmpty()) {
      curr = evenQueue.poll();
      prev.next = curr;
      prev = curr;
    }
    return head;
  }
  public ListNode oddEvenListOnePass(ListNode head) {
    ListNode even;
    ListNode curr = head;
    ListNode append = head.next;
    while(curr.next.next != null) {
      even = curr.next;
      curr.next = curr.next.next;
      curr = even;
    }
    curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = append;
    return head;
  }

  public ListNode oddEvenListSol(ListNode head) {
    if (head == null) return null;
    ListNode odd = head, even = head.next, evenHead = even;
    while (even != null && even.next != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
    }
    odd.next = evenHead;
    return head;
  }


    public static void main(String[] args) {
    OddEvenLinkedList main = new OddEvenLinkedList();
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
    main.oddEvenList(a);
    System.out.println(a);
  }
}
