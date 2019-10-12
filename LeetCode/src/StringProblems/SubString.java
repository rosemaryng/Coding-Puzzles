package StringProblems;

import java.util.*;

public class SubString {

  public static int lengthOfLongestSubstring(String s) {
    int length = s.length();
    if (length <= 1) {
      return length;
    }
    int max = 0;
    int currCount;
    for (int i = 0; i < length && length - i >= max ; i++) {
      currCount = 0;
      List<Character> charsAppeared = new ArrayList<>();
      for (int j = i; j < s.length(); j++) {
        Character current = s.charAt(j);
        if (charsAppeared.contains(current)) {
          break;
        } else {
          charsAppeared.add(current);
          currCount++;
        }
      }
      max = Math.max(currCount, max);
    }

    return max;
  }

  public int lengthOfLongestSubstringSlidingWindow(String s) {
    int n = s.length();
    Set<Character> set = new HashSet<>();
    int ans = 0, i = 0, j = 0;
    while (i < n && j < n) {
      // try to extend the range [i, j]
      if (!set.contains(s.charAt(j))){
        set.add(s.charAt(j++));     // add j then increment j
        ans = Math.max(ans, j - i);
      }
      else {
        set.remove(s.charAt(i++));  // just remove i, j is added in next loop
      }
    }
    return ans;
  }

  /*
  Explanation: The above solution requires at most 2n steps. In fact, it could be optimized to require only n steps.
  Instead of using a set to tell if a character exists or not, we could define a mapping of the characters to its index.
  Then we can skip the characters immediately when we found a repeated character.

  The reason is that if s[j]s[j] have a duplicate in the range [i, j)[i,j) with index j'j′,
  we don't need to increase ii little by little. We can skip all the elements in the range [i, j'][i,j′]
  and let ii to be j' + 1j +1 directly.
  O(n)
   */
  public static int lengthOfLongestSubstringImproved(String s) {
     Map<Character, Integer> map = new HashMap<>();
//     int count = 0;
     int max = 0;
     int sLength = s.length();
    for (int i = 0, head = 0; i < sLength; i++) {
      Character currChar = s.charAt(i);
      if (map.containsKey(currChar)) {
        head = Math.max(head, map.get(currChar) + 1);
      }
      map.put(currChar, i);
      max = Math.max(max, i - head + 1);
      System.out.println(currChar + ": " + max);

    }
     return max;
  }

  // Replace map with table?
  public class Solution {
    public int lengthOfLongestSubstring(String s) {
      int n = s.length(), ans = 0;
      int[] index = new int[128]; // current index of character
      // try to extend the range [i, j]
      for (int j = 0, i = 0; j < n; j++) {
        i = Math.max(index[s.charAt(j)], i);
        ans = Math.max(ans, j - i + 1);
        index[s.charAt(j)] = j + 1;
      }
      return ans;
    }
  }
  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstringImproved("adab"));
  }
}