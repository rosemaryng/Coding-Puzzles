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

  /**
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode(int x) { val = x; }
   * }
   */
  class Solution {
    public void reorderList(LinkNode head) {
      LinkNode last = head;
      int length;
      Stack<LinkNode> stack = new Stack<>();
      stack.add(head);
      while (last.next != null) {
        last = last.next;
        stack.add(last);
      }
      LinkNode curr = head;
      for (int i = 0; i < stack.size()/2 && curr.next != null; i++) {
        LinkNode originalNext = curr.next;


      }


    }
  }
}
