package Graphs;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
  public String decodeString(String s) {
    if (s == null || s.isEmpty()) return "";
    StringBuilder sb = new StringBuilder();
    char[] charsS = s.toCharArray();
    Deque<String> stack = new ArrayDeque<>();
    for (int i = 0; i < charsS.length; i++) {
      char c = charsS[i];
      if (c == ']') { // if char is ], pop out the string to repeat and the repeat number
        StringBuilder charsToRepeat = new StringBuilder();
        while (!stack.isEmpty() && Character.isLetter(stack.peek().charAt(0))) { // build the string to repeat
          charsToRepeat.insert(0, stack.pop());
        }
        if ("[".equals(stack.peek())) stack.pop(); // pop out the [ char next to the repeat number
        StringBuilder kRepeats = new StringBuilder(); //store integer as string
        while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) { // build the repeat number
          kRepeats.insert(0, stack.pop());
        }
        Integer k = kRepeats.length() > 0 ? Integer.parseInt(kRepeats.toString()) : 1;
        StringBuilder charsToPush = new StringBuilder();
        for (int j = 0; j < k; j++) { // build the string to repeat k times
          charsToPush.append(charsToRepeat);
        }
        stack.push(charsToPush.toString()); // push back the repeated string into the stack
      } else {
        stack.push("" + c); // push the characters until you find a ]
      }
    }
    while (!stack.isEmpty()) { // build the final string
      sb.insert(0, stack.pop());
    }
    return sb.toString();
  }
}
