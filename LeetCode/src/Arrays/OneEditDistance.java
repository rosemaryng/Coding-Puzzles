package Arrays;

public class OneEditDistance {
  public static boolean isOneEditDistance(String s, String t) {
    if (Math.abs(s.length() - t.length()) > 1) return false;
    int minLength = Math.min(s.length(), t.length());
    int i = 0;
    while (i <= minLength - 1 && s.charAt(i) == t.charAt(i) ) {
      i++;
    }
    System.out.println(i);
    if (i == minLength) return true;
    for (int j = 1; j < minLength-i+1 ; j++) {
      if (s.charAt(s.length() - j) != t.charAt((t.length() - j))) return false;

    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isOneEditDistance("abd", "abc"));
  }
}
