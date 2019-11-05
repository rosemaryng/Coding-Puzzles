package BlackRockInterview;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class PatternRecognition {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
//    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
//    BufferedReader in = new BufferedReader(reader);
//    String line;
//    while ((line = in.readLine()) != null) {
//      String[] splittedInput = line.split(";");
//      String pattern = splittedInput[0];
//      String blobs = splittedInput[1];
//      PatternRecognition.doSomething(pattern, blobs);
//      System.out.println(pattern);
//      System.out.println(blobs);
//    }
    PatternRecognition.doSomething("bc", "bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32");

//    System.out.println(PatternRecognition.patternRecogniser("bc","bcdefbcbebc" ));
  }

  public static void doSomething(String pattern, String blobs) {
    String splitArray[] = blobs.split("\\|");
    System.out.println(PatternRecognition.toString(splitArray));
    int total = 0;
    for (int i = 0; i < splitArray.length ; i++) {
//      System.out.println(splitArray[i]);
      int count = patternRecogniser(pattern, splitArray[i]);
      System.out.print(count + "|");
      total = total + count;
    }
    System.out.print(total);

  }

  private static int patternRecogniser(String pattern, String str) {
    int length = str.length();
    int patternLength = pattern.length();
    int count = 0;
    for (int i = 0; i < length; i++) {
      int patternIndex = 0;
      if (str.charAt(i) == pattern.charAt(patternIndex)) {
        patternIndex++;
        for (int j = i + 1; j < i + 1 + patternLength - 1 && j < length; j++) {
          if (str.charAt(j) != pattern.charAt(patternIndex)) {
            break;
          }
          count += (j == i + 1 + patternLength - 2) ? 1 : 0;
        }
      }
    }
    return count;
  }

//  private int patternCounter(String str, String pattern) {
//
//  }

  public static String toString(Object[] array) {
    String res = "{";
    for (int i = 0; i < array.length ; i++) {
      res += array[i];
      if (i != array.length - 1) {
        res += ", ";
      }
    }
    return res + "}";

  }
}