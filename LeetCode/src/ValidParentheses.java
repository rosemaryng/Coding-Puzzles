import java.util.*;

public class ValidParentheses {
  public boolean isValid(String s) {
    if ((s.length() % 2) != 0) return false;
    Map<Character, Character> map = new HashMap<>();
    map.put('[', ']');
    map.put('(', ')');
    map.put('{', '}');
    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        stack.push(c);
      } else if (map.containsValue(c)) {
        if (map.get(stack.pop()) != c) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    ValidParentheses validParentheses = new ValidParentheses();
    System.out.println(    validParentheses.isValid("([)]"));
  }
}
