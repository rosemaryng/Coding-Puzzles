package Arrays;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringCompression {
  public static int compress(char[] chars) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < chars.length; i++) {
      map.put(chars[i], map.getOrDefault(chars[i],0) + 1);
    }
    int pointer = 0;
    for (Map.Entry<Character, Integer> set:map.entrySet()) {
      int i = set.getValue();
      chars[pointer++] = set.getKey();
      if (i > 1) {
        char digits[] = Integer.toString(i).toCharArray();
        for (int j = 0; j < digits.length ; j++) {
          chars[pointer++] = digits[j];
        }
      }
    }
    return pointer;
  }

  public static int compressNoExtraSpace(char[] chars) {
    int count = 0, pointer = 1;
    char prev = chars[0];
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == prev) {
        count++;
      }
      if (i == chars.length - 1 || chars[i] != prev) {
        if (count > 1) {
          char digits[] = Integer.toString(count).toCharArray();
          for (int j = 0; j < digits.length; j++) {
            chars[pointer++] = digits[j];
          }
        }
        if (i < chars.length - 1 ) {
          chars[pointer++] = chars[i];
          count = 1;
          prev = chars[i];
        }
      }
    }
    return pointer;
  }

  public static void main(String[] args) {
    char array[] = {'a', 'a'};
    System.out.println(compressNoExtraSpace(array));
  }
}
