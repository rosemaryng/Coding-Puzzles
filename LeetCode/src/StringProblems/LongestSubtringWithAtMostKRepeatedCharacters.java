package StringProblems;

import java.util.*;

public class LongestSubtringWithAtMostKRepeatedCharacters {
  public static int lengthOfLongestSubstringKDistinct(String s, int k) {
    int length = s.length();
    if (length < 1 || k == 0) return 0;
    int n = 0, max = 0;
    for (int i = 0; i < length; i++) {
      Set<Character> set = new HashSet<>();
      n = 0;
      for (int j = i; j < length && set.size() <= k; j++) {
        set.add(s.charAt(j));
        if (set.size() > k) break;
        n++;
        System.out.println("current n: " + n);
      }
      max = Math.max(max, n);
      System.out.println(max);
    }
    return max;
  }

  public static int lengthOfLongestSubstringKDistinctImproved(String s, int k) {
    int length = s.length();
    if (length < 1 || k <= 0) return 0;
    int head = 0, max = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < length && head <= i; i++) {
       Character c = s.charAt(i);
       map.put(c, i);
       System.out.println(map);
       if (map.size() > k) {
         int index = Collections.min(map.values());
         char toRemove = s.charAt(index);
         map.remove(toRemove);
         head = index + 1;
       }
       max = Math.max(i - head + 1, max);
       System.out.println(max);
    }
    return max;
  }

  public static void main(String[] args) {
//    lengthOfLongestSubstringKDistinct("abaccc", 2);
    System.out.println(lengthOfLongestSubstringKDistinctImproved("aa",2 ));
  }
}
