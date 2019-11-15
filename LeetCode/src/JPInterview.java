
import java.util.*;

public class JPInterview {
  public static void main(String[] args) {
//    System.out.println("Is Happy Number? " + calculateHappyNumber(7));
    System.out.println(wellFormedString("[]["));
  }

  private static int calculateHappyNumber(int i) {
    if (i <= 0) {
      throw new IllegalArgumentException("Input must be positive");
    }
    if (i == 1) return 1;
    HashSet<Integer> set = new HashSet<>(); // a set to keep track of numbers that has been added to the list before
    while (!set.contains(i)) {
      set.add(i);
      String digits = Integer.toString(i);
      i = 0;
      for (int j = 0; j < digits.length(); j++) {
        i += Math.pow(Character.getNumericValue(digits.charAt(j)), 2); // Adding the square of the current digit
      }
      if (i == 1) {
        return 1;
      }
      System.out.println(set);
    }
    return 0;
  }

  private static boolean wellFormedString(String string) {

    if (!isMultipleOfTwo(string.length())) return false;
    Map<Character, Character> map = new HashMap<>();
    map.put('[', ']');
    map.put('(', ')');
    map.put('{', '}');

    char temp = ' ';

    for (int i = 0; i < string.length(); i++) {
      char curr = string.charAt(i);
      if (isMultipleOfTwo(i)) {
        if (map.containsKey((curr))) {
          temp = curr;
        } else {
          return false;
        }
      } else {
        if (!map.containsValue(curr)) {
          return false;
        } else {
          if (!map.get(temp).equals(curr)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  private static boolean isMultipleOfTwo(int i) {
    return (i % 2) == 0;
  }
}
//}
//
//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.nio.charset.StandardCharsets;
//
//        import java.util.HashMap;
//        import java.util.Map;
//
//public class Main {
//  /**
//   * Iterate through each line of input.
//   */
//  public static void main(String[] args) throws IOException {
//    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
//    BufferedReader in = new BufferedReader(reader);
//    String line;
//    while ((line = in.readLine()) != null) {
//      boolean ans = wellFormedString(line);
//      if (ans) {
//        System.out.println("True");
//      } else {
//        System.out.println("False");
//      }
//    }
//  }
//
//  private static boolean wellFormedString(String string) {
//
//    if (!isMultipleOfTwo(string.length())) return false;
//    Map<Character, Character> map = new HashMap<>();
//    map.put('[', ']');
//    map.put('(',')');
//    map.put('{', '}');
//
//    char temp = ' ';
//
//    for (int i = 0; i < string.length(); i++) {
//      char curr = string.charAt(i);
//      if (isMultipleOfTwo(i)) {
//        if (map.containsKey((curr))) {
//          temp = curr;
//        } else {
//          return false;
//        }
//      } else {
//        if (!map.containsValue(curr)) {
//          return false;
//        } else {
//          if (!map.get(temp).equals(curr)) {
//            return false;
//          }
//        }
//      }
//    }
//    return true;
//  }
//
//  private static boolean isMultipleOfTwo(int i) {
//    return (i % 2) == 0;
//  }
//}