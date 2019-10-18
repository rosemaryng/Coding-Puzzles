package StringProblems;

public class Easy {
  public static String longestCommonPrefix(String[] strs) {
    if (strs.length < 1) return "";
    String commonPrefix;
    String res = strs[0];

    for (int i = 0; i < strs.length; i++) {
      commonPrefix = "";
      for (int j = 0; j < Math.min(res.length(), strs[i].length()); j++) {
        if (strs[i].charAt(j) == res.charAt(j)) {
          System.out.println(strs[i].charAt(j) + ", " + res.charAt(j));
          commonPrefix += res.charAt(j);
        } else {
          break;
        }
      }
      if (commonPrefix.length() < res.length()) {
        res = commonPrefix;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    String str[] = {"aca","cba"};
    System.out.println(longestCommonPrefix(str));
  }
}
