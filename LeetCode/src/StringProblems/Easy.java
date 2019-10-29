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

  public static int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int j = 0;
    for (int i = 1; i < nums.length ; i++) {
      if (nums[i] != nums[j]) {
        j++;
        nums[j] = nums[i];
      }
    }
    return j + 1;
  }

  public static void main(String[] args) {
    String str[] = {"aca","cba"};
    System.out.println(longestCommonPrefix(str));
    int array[] = {1,1,3,3,5,5,5,6};
    System.out.println(removeDuplicates(array));
  }
}
