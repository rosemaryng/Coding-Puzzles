package Recursion;

import java.util.Arrays;

public class StringReverse { //not done
  //  Input: ["h","e","l","l","o"]
//  Output: ["o","l","l","e","h"]
  public static void reverseStringRecursion(char[] s) {
    reverseStringRecursionHelper(s, 0);
  }

  private static void reverseStringRecursionHelper(char[] s, int index) {
    int length = s.length;
    if (index >= length - index) {
      return;
    }
    char temp = s[index];
    s[index] = s[length - 1 - index];
    s[length - 1 - index] = temp;
    reverseStringRecursionHelper(s, index + 1);
  }

  public static void reverseStringIteration(char[] s) {
    int head = 0, tail = s.length - 1;
    while (head < tail) {
      char temp = s[head];
      s[head++] = s[tail];
      s[tail--] = temp;
    }
  }

  public static void main(String[] args) {
    char string[] = {'h','i','g', 't'};
    System.out.println(string);
    reverseStringIteration(string);
    System.out.println(string);
  }
}
