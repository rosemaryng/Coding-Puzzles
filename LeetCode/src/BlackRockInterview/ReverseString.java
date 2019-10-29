package BlackRockInterview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ReverseString {

  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      ReverseString.reverseSpell(line);
    }
  }

  public static void reverseSpell(String input) {
    StringBuilder res = new StringBuilder();
    for (int i = input.length() - 1; i >= 0 ; i--) {
      char currentChar = input.charAt(i);
      if (Character.isAlphabetic(currentChar) || Character.isDigit(currentChar)) {
        currentChar = Character.isUpperCase(currentChar) ? Character.toLowerCase(currentChar) : currentChar;
        res.append(currentChar);
        res.append(i != 0 ? '-' : "" );
      }
    }
    System.out.println(res.toString());
  }
}

