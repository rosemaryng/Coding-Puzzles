package Recursion;

import java.util.*;

public class PhoneNumberMapping {
  Map<String, String> phone = new HashMap<String, String>() {{
    put("2", "abc");
    put("3", "def");
    put("4", "ghi");
    put("5", "jkl");
    put("6", "mno");
    put("7", "pqrs");
    put("8", "tuv");
    put("9", "wxyz");
  }};

  List<String> result = new ArrayList<>();

  public List<String> letterCombinations(String digits) {
    if (digits.length() != 0)
      letterCombination("", digits);
    return result;
  }

  private void letterCombination(String res, String subDigits) {
    if (subDigits.length() == 0) {
      result.add(res);
      System.out.println(result);
    } else {
      String currMapping = phone.get(Character.toString(subDigits.charAt(0)));
      for (int i = 0; i < currMapping.length(); i++) {
        String subRes = res + currMapping.charAt(i);
        letterCombination(subRes, subDigits.substring(1));
      }
    }
  }

  public static void main(String[] args) {
    PhoneNumberMapping phone = new PhoneNumberMapping();
    phone.letterCombinations("88");
    System.out.println(phone.result);

  }

}

