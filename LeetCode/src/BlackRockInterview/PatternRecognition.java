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
    PatternRecognition.patternCounter("bc", "bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32");
  }

  private static void patternCounter(String pattern, String blobs) {
    int total = 0, currentCount = 0;
    int patternLength = pattern.length();
    int length = blobs.length();
    for (int i = 0; i < length; i++) {
      if (blobs.charAt(i) == '|') {
        System.out.print(currentCount + "|");
        total += currentCount;
        /* reset index to 0 */
        currentCount = 0;
      }
      if (patternLength > 0) {
        currentCount += checkCurrentSegment(blobs, pattern, i, length);
      }
    }
    System.out.print(currentCount + "|" + (total + currentCount));
  }

  // Checks whether starting from current character, would a pattern be formed
  private static int checkCurrentSegment(String blobs, String pattern, int start, int length) {
    int end = start + pattern.length() - 1;
    if (length <= end) return 0;
    int patternIndex = 0;
    for (int i = start; i <= end; i++) {
      if (blobs.charAt(i) != pattern.charAt(patternIndex)) return 0;
      patternIndex++;
    }
    return 1;
  }
}


//
//        int end = i + patternLength - 1;
//        for (int start = i; start <= end && end < length; start++) {
//          if (blobs.charAt(start) != pattern.charAt(patternIndex)) {
//            break;
//          }
//          patternIndex++;
//          currentCount += (start == end) ? 1 : 0;
//        }
//      }

//      if (blobs.charAt(i) == pattern.charAt(patternIndex)) {
//        if (patternLength == 1) {
//          currentCount++;
//        } else {
//          patternIndex++;
//          int end = i + patternLength - 1;
//          int start;
//          for (start = i + 1; start <= end && end < length; start++) {
//            if (blobs.charAt(start) != pattern.charAt(patternIndex)) {
//              break;
//            }
//            patternIndex++;
//          }
//          currentCount += start == end ? 1 : 0;
//        }
//      }

//  public static void doSomethingelse(String pattern, String blobs) {
//    String splitArray[] = blobs.split("\\|");
//    System.out.println(PatternRecognition.toString(splitArray));
//    int total = 0;
//    for (int i = 0; i < splitArray.length ; i++) {
////      System.out.println(splitArray[i]);
//      int count = patternRecogniser(pattern, splitArray[i]);
//      System.out.print(count + "|");
//      total = total + count;
//    }
//    System.out.print(total);
//
//  }

//  private static int patternRecogniser(String pattern, String str) {
//    int length = str.length();
//    int patternLength = pattern.length();
//    int count = 0;
//    for (int i = 0; i < length; i++) {
//      int patternIndex = 0;
//      if (str.charAt(i) == pattern.charAt(patternIndex)) {
//        patternIndex++;
//        for (int j = i + 1; j < i + 1 + patternLength - 1 && j < length; j++) {
//          if (str.charAt(j) != pattern.charAt(patternIndex)) {
//            break;
//          }
//          count += (j == i + 1 + patternLength - 2) ? 1 : 0;
//        }
//      }
//    }
//    return count;
//  }

//  private int patternCounter(String str, String pattern) {
//
//  }
//
//  public static String toString(Object[] array) {
//    String res = "{";
//    for (int i = 0; i < array.length ; i++) {
//      res += array[i];
//      if (i != array.length - 1) {
//        res += ", ";
//      }
//    }
//    return res + "}";
//
//  }
