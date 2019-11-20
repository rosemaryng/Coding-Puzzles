package DynamicProgramming;

public class LongestParlindromicSubstring {

  // Method: Start from middle
  public static String longestPalindrome(String s) {
    String res = "";
    boolean isEven = (s.length() % 2 == 0);
    int middle = s.length() / 2;
    if (isEven) {
      for (int i = 0; i < middle; i++) {
        if (s.charAt(middle - 1 - i) != s.charAt(middle + i)) {
          if (s.length() >= 3) {
            String r1 = longestPalindrome(s.substring(0, s.length() - 2));
            String r2 = longestPalindrome(s.substring(1, s.length() - 1));
            res = r1.length() >= r2.length() ? r1 : r2;
            return res;
          } else if (!isPalindrome(s)) {
            return null;
          }
        }
      }
    } else {
      for (int i = 0; i < middle; i++) {
        if (s.charAt(middle - 1 - i) != s.charAt(middle + 1 + i)) {
          if (s.length() >= 3) {
            String r1 = longestPalindrome(s.substring(0, s.length() - 2));
            String r2 = longestPalindrome(s.substring(1, s.length() - 1));
            res = r1.length() >= r2.length() ? r1 : r2;
            return res;
          } else if (!isPalindrome(s)) {
            return null;
          }
        }

      }
    }
    return s;
  }

  private static boolean isPalindrome(String s) {
    int len = s.length();
    for (int i = 0; i < len / 2; i++) {
      if (s.charAt(i) != s.charAt(len - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome(""));
    System.out.println(longestPalindrome("abbbdfa"));

  }

}
