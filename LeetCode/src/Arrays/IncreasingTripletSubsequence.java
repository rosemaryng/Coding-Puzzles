package Arrays;

public class IncreasingTripletSubsequence {
//  public static boolean increasingTriplet(int[] nums) {
//    if (nums.length < 3) return false;
//    int sum = nums[0];
//    int count = 1;
//    for (int i = 1; i < nums.length; i++) {
//      if (nums[i] > sum/i) count++;
//      if (count == 3) return true;
//      sum += nums[i];
//    }
//    return false;
//  }
  public static boolean increasingTriplet(int[] nums) {
    if (nums.length < 3) return false;
    int min1 = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= min1) min1 = nums[i]; // update min1
      else if (nums[i] <= min2) min2 = nums[i]; // min2 > nums[i] > min1 update min2
      else return true; // nums[i] > min2 > min1
    }
    return false;
  }

  public static void main(String[] args) {
    int[] a = {1,5,2,3};
    System.out.println(increasingTriplet(a));
  }

}
