package ListAndNumbers;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
  public static List<Integer> sequentialDigits(int low, int high) {
    int curr = low;
    List<Integer> list = new ArrayList<>();
    while (curr < high) {
      System.out.println('1');
      curr = nextSeqDigit(curr);
      if (curr < high) {
        list.add(curr);
        System.out.println(list);
      }
    }
    return list;
  }


  public List<Integer> seqIntGenerator(int low, int high) {
    int lowRange = (int) Math.pow(low, 0.1);
    int highRange = (int) Math.pow(high, 0.1);
    for (int i = lowRange; i < highRange ; i++) {

    }
    return null;
  }




  public static Integer nextSeqDigit(int num) {
    String digit = Integer.toString(num);
    int len = digit.length();
    StringBuilder validSequentialDigit = new StringBuilder();
    // check first digit
    int firstDigit = digit.charAt(0) - 48;
//    if (9 - firstDigit >=)


    validSequentialDigit.append(digit.charAt(0));
    if (len == 1 && num < 9) {
      return num + 1;
    }
    if (num == 9) return nextSeqDigit(10);
    for (int i = 0; i < len - 1; i++) {
      int lastDigit = validSequentialDigit.charAt(i) - 48;
      if (lastDigit == 9) break;
      validSequentialDigit.append(lastDigit + 1);
    }
    int nextSeqDigit = Integer.parseInt(String.valueOf(validSequentialDigit.toString()));
    System.out.println(nextSeqDigit);
    if(nextSeqDigit <= num) {

      return nextSeqDigit((int) Math.pow(10, len));
    }
    System.out.println(validSequentialDigit.toString());

    return nextSeqDigit;
  }
  public static void main(String[] args) {
    System.out.println(nextSeqDigit(12));
//    System.out.println(sequentialDigits(0,100));
  }
}
