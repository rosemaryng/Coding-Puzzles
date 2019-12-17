package Arrays;

import java.util.*;

public class GroupAnagram {
  public List<List<String>> groupAnagrams(String[] strs) {
    if (strs.length == 0) return new ArrayList();
    Map<String, List> map = new HashMap<>();
    for (String s : strs) {
      char[] ca = s.toCharArray();
      Arrays.sort(ca);
      String key = String.valueOf(ca);
      if (!map.containsKey(key)) map.put(key, new ArrayList());
      map.get(key).add(s);
    }
    return new ArrayList(map.values());
  }
  public List<List<String>> groupAnagrams2(String[] strs) {
    if (strs.length == 0) return new ArrayList();
    Map<String, List> ans = new HashMap<String, List>();
    int[] count = new int[26];
    for (String s : strs) {
      Arrays.fill(count, 0);
      for (char c : s.toCharArray()) count[c - 'a']++;

      StringBuilder sb = new StringBuilder("");
      for (int i = 0; i < 26; i++) {
        sb.append('#');
        sb.append(count[i]);
      }
      String key = sb.toString();
      if (!ans.containsKey(key)) ans.put(key, new ArrayList());
      ans.get(key).add(s);
    }
    return new ArrayList(ans.values());
  }
  public static void main(String[] args) {
    GroupAnagram ana = new GroupAnagram();
    String[] array = {"eat","tea","tan","ate","nat","bat"};
    System.out.println(ana.groupAnagrams(array));

    // Map test
    Map<String, List> map = new HashMap<>();
    List<Integer> l = new ArrayList<>();
    map.put("a", l);
    map.get("a").add(2);
    System.out.println(map);
  }

//  List<List<String>> res = new ArrayList<>();
//    Arrays.sort(strs);
//    for (String s:strs) {
//    for (List<String> l:res) {
//      for (String str:l) {
//        if (Easy.isAnagramSortMethod(s, str)) {
//          l.add(str);
//        } else {
//          List<String> newList = new ArrayList<>();
//          newList.add(str);
//          res.add(newList);
//        }
//      }
//    }
//  }
//    return res;

}
