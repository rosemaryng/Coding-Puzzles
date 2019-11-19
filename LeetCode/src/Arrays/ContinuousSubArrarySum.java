package Arrays;

import java.util.HashMap;

public class ContinuousSubArrarySum {
  int[] nums = {1, 2, 3, 3, 1};

  public int subArraySum(int[] nums, int k) {
    int count = 0;
    for (int start = 0; start < nums.length; start++) {
      int sum=0;
      for (int end = start; end < nums.length; end++) {
        sum += nums[end];
        if (sum >= k) {
          count += sum == k ? 1 : 0;
          break;
        }
      }
    }
    return count;
  }

  public int subarraySumSolMap(int[] nums, int k) {
    int count = 0, sum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1); //necessary if the first element = k
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      // if the condition gets hit that means that we've found a count where the sum is equal to k
      // and we increment the value of count each time we match this condition
      if (map.containsKey(sum - k)) count += map.get(sum - k);
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }

  public int subArraySumCumulativeSumMethod(int[] nums, int k) {
//    int count = 0, sum = 0;
//    for (int i = 0; i < nums.length; i++) {
//      sum += nums[i];
//      nums[i] = sum;
//    }
//    for (int start = 0; start < nums.length; start++) {
//      if (nums[])
//      for (int end = start; end <= nums.length; end++) {
//        if (sum[end] - sum[start] == k)
//          count++;
//      }
//    }
  return 0;

  }

  public static void main(String[] args) {
    ContinuousSubArrarySum sum = new ContinuousSubArrarySum();
    System.out.println(sum.subArraySum(sum.nums, 4));
  }
}
