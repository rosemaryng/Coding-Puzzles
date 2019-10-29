package Recursion;

public class StringReverse {
  //  Input: ["h","e","l","l","o"]
//  Output: ["o","l","l","e","h"]
  public static void reverseStringRecursion(char[] s) {
    reverseStringRecursionHelper(s);
  }

  private static void reverseStringRecursionHelper(char[] s) {
    int length = s.length;
    if (length == 0) {
      return;
    }
    char temp = s[0];
    s[0] = s[length - 1];
    s[length - 1] = temp;
  }


  public static void main(String[] args) {
    char string[] = {'h','i','g'};
    System.out.println(string);
    reverseStringRecursion(string);
    System.out.println(string);
  }
}
