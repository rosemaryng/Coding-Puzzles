package LinkedList;

import java.util.ArrayDeque;
import java.util.Queue;

public class AddTwoNumbers {
  public static ListNode addTwoNumbersMine(ListNode l1, ListNode l2) {
    ListNode l1Curr = l1, l2Curr = l2;
    ListNode dummyHead = new ListNode(0), curr = dummyHead;
    int carry = 0;
    while (l1Curr != null || l2Curr != null || carry == 1) {
      int add = carry;
      if (l2Curr != null) {
        add += l2Curr.val;
        l2Curr = l2Curr.next;
      }
      if (l1Curr != null ) {
        add += l1Curr.val;
        l1Curr = l1Curr.next;
      }
      if (add > 9) {
        carry = 1;
        add = add % 10;
      } else {
        carry = 0;
      }
      curr.next = new ListNode(add);
      curr = curr.next;
    }
    return dummyHead.next;
  }
  //Same algo as mine
  public ListNode addTwoNumbersSol(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
      int x = (p != null) ? p.val : 0;
      int y = (q != null) ? q.val : 0;
      int sum = carry + x + y;
      carry = sum / 10;
      curr.next = new ListNode(sum % 10);
      curr = curr.next;
      if (p != null) p = p.next;
      if (q != null) q = q.next;
    }
    if (carry > 0) {
      curr.next = new ListNode(carry);
    }
    return dummyHead.next;
  }
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
//
//    while (l1Curr.next != null || l2Curr.next != null) {
//      if (l1Curr == null) {
//        res = l2Curr.val;
//      } else if (l2Curr == null) {
//        res = l1Curr.val;
//      } else {
//        res = (l1Curr.val + l2Curr.val);
//      }
//      System.out.println(res);
//
//      if (res > 10 && carry) {
//        curr.next = new ListNode(res - 10 + 1);
//      } else if (res > 10 && !carry) {
//        curr.next = new ListNode(res - 10);
//      } else if (res < 10 && carry) {
//        curr.next = new ListNode(res + 1);
//      } else {
//        curr.next = new ListNode(res);
//      }
//      queue.add(curr);
//      curr = curr.next;
//      l1Curr = l1Curr.next;
//      l2Curr = l2Curr.next;
//    }
//    if (carry) {
//      curr.next = new ListNode(1);
//    }

    return ((ArrayDeque<ListNode>) queue).peekFirst();
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
    System.out.println("answer: " + (a));

  }
}
