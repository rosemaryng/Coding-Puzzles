package ListAndNumbers;

import java.util.ArrayDeque;
import java.util.Queue;

public class AddTwoNumbers {
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int res = getNum(l1) + getNum(l2);
    System.out.println(res);
    ListNode head = null;
    ListNode curr = null;
    int digits = (int) (Math.log10(res)) + 1;
    System.out.println("num digits: " + digits);
    int digit;
    int value;
    for (int i = digits; i > 0; i--) {
      System.out.println(i);
      digit = (int) Math.pow(10, i - 1);
      System.out.println("position " + digit);
      value = res/digit;
      System.out.println("the digit is: " + value);
      res = res - digit * value;
      System.out.println("res after deduction: " + res);
      head = new ListNode(value);
      System.out.println("current curr: " + curr);
      head.next = curr;
      System.out.println(head.next);
      curr = head;
      System.out.println(head );
    }
    return head;
  }

  private static int getNum(ListNode l) {
    int res = 0;
    int pointer = 0;
    ListNode currNode = l;
    while (currNode != null) {
      res += l.val * (int) Math.pow(10, pointer);
      currNode = currNode.next;
      pointer++;
    }
    return res;
  }

  public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    ListNode l1Curr = l1;
    ListNode l2Curr = l2;
    ListNode curr = null;
    boolean carry = false;
    int res;
    Queue<ListNode> queue = new ArrayDeque<>();

    while (l1Curr.next != null || l2Curr.next != null) {
      if (l1Curr == null) {
        res = l2Curr.val;
      } else if (l2Curr == null) {
        res = l1Curr.val;
      } else {
        res = (l1Curr.val + l2Curr.val);
      }
      System.out.println(res);

      if (res > 10 && carry) {
        curr.next = new ListNode(res - 10 + 1);
      } else if (res > 10 && !carry) {
        curr.next = new ListNode(res - 10);
      } else if (res < 10 && carry) {
        curr.next = new ListNode(res + 1);
      } else {
        curr.next = new ListNode(res);
      }
      queue.add(curr);
      curr = curr.next;
      l1Curr = l1Curr.next;
      l2Curr = l2Curr.next;
    }
    if (carry) {
      curr.next = new ListNode(1);
    }

    return ((ArrayDeque<ListNode>) queue).peekFirst();
   }


  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
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

  public static void main(String[] args) {
    ListNode a = new ListNode(1);
    ListNode b = new ListNode(2);
    ListNode c = new ListNode(3);
    ListNode d = new ListNode(1);
    ListNode e = new ListNode(2);
    ListNode f = new ListNode(3);
    a.next = b;
    b.next = c;
    f.next = e;
    d.next = d;

    System.out.println("answer: " + addTwoNumbers2(a,f));

  }
}
