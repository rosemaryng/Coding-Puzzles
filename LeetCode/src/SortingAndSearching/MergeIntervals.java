package SortingAndSearching;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
  public int[][] merge(int[][] intervals) {
    int length = intervals.length;
    if (length <= 1) return intervals;
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    int pointer = 0;
    for (int i = 1; i < length; i++) {
      if (intervals[i][0] <= intervals[pointer][1]) {
        intervals[pointer][1] = Math.max(intervals[i][1], intervals[pointer][1]);
      } else {
        pointer++;
        intervals[pointer][0] = intervals[i][0];
        intervals[pointer][1] = intervals[i][1];
      }
    }
    return Arrays.copyOfRange(intervals, 0, pointer);
  }
}
