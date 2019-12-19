//package Arrays;
//
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class MinimumSlidingWindow {
//  public static String minWindow(String s, String t) {
//    int start = 0, end = 0;
//    Map<Character, Integer> map = new HashMap<>();
//    String ret = s;
//    int found = 0;
//    while (end < s.length()) {
//      char curr = s.charAt(end);
//      System.out.println("curr: " + curr);
//      if (t.contains(Character.toString(curr))) {
//        map.put(curr, map.getOrDefault(curr, 0) + 1);
//        System.out.println(map);
//        while (map.size() == t.length() && (end - start) >= t.length() - 1) {
//          found++;
//          char head = s.charAt(start);
//          System.out.println(head);
//          if (map.containsKey(head)) {
//            if (map.get(head) == 1) {
//              ret = ret.length() > end - start ? s.substring(start, end + 1) : ret;
//              map.remove(head);
//              System.out.println(map);
//              System.out.println(ret);
//              start++;
//              break;
//            } else {
//              map.put(head, map.getOrDefault(head, 0) - 1);
//            }
//          }
//          start++;
//        }
//        if (ret.length() == t.length()) return ret;
//      }
//      end++;
//    }
//    return found == 0 ? "" : ret;
//  }
//  public String minWindowOptimized(String s, String t) {
//
//    if (s.length() == 0 || t.length() == 0) return "";
//    Map<Character, Integer> dictT = new HashMap<>();
//
//    for (int i = 0; i < t.length(); i++) {
//      int count = dictT.getOrDefault(t.charAt(i), 0);
//      dictT.put(t.charAt(i), count + 1);
//    }
//    int required = dictT.size();
//    // Filter all the characters from s into a new list along with their index.
//    // The filtering criteria is that the character should be present in t.
//    List<Pair<Integer, Character>> filteredS = new ArrayList<>();
//    for (int i = 0; i < s.length(); i++) {
//      char c = s.charAt(i);
//      if (dictT.containsKey(c)) {
//        filteredS.add(new Pair<>(i, c));
//      }
//    }
//
//    int l = 0, r = 0, formed = 0;
//    Map<Character, Integer> windowCounts = new HashMap<>();
//    int[] ans = {-1, 0, 0};
//
//    // Look for the characters only in the filtered list instead of entire s.
//    // This helps to reduce our search.
//    // Hence, we follow the sliding window approach on as small list.
//    while (r < filteredS.size()) {
//      char c = filteredS.get(r).getValue();
//      int count = windowCounts.getOrDefault(c, 0);
//      windowCounts.put(c, count + 1);
//
//      if (dictT.containsKey(c) && windowCounts.get(c).equals(dictT.get(c))) {
//        formed++;
//      }
//
//      // Try and contract the window till the point where it ceases to be 'desirable'.
//      while (l <= r && formed == required) {
//        c = filteredS.get(l).getValue();
//
//        // Save the smallest window until now.
//        int end = filteredS.get(r).getKey();
//        int start = filteredS.get(l).getKey();
//        if (ans[0] == -1 || end - start + 1 < ans[0]) {
//          ans[0] = end - start + 1;
//          ans[1] = start;
//          ans[2] = end;
//        }
//
//        windowCounts.put(c, windowCounts.get(c) - 1);
//        if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
//          formed--;
//        }
//        l++;
//      }
//      r++;
//    }
//    return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
//  }
////
////    for (int i = 0; i < s.length(); i++) {
////      char curr = s.charAt(i);
////      if (t.contains(Character.toString(curr))) {
////        if (map.containsKey(curr)) {
////          int pos = map.get(curr);
////          if (start = curr)
////        }
////        map.put(curr, map.getOrDefault(curr, 0));
////      }
////
////    }
////
////  }
//
//  public static void main(String[] args) {
//    System.out.println(minWindow("ADOBECODEBANC","ABC"));
//  }
//}
