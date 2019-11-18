package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NextPermutation {

//  We need to find the next lexicographic permutation of the given list of numbers than the number formed by the given array.
//  Lexicographic Permutation
//  For array (1,2,3,4)
// (1,2,4,3), (1,3,2,4), (1,3,4,2), (1,4,2,3), (1,4,3,2)


  public static void nextPermutation(int[] nums) {
//    int length = nums.length;
//    if (length <= 1) return;
//    int prev = nums[length - 1];
//    int i = length - 2;
//    while (i >= 0 && nums[i] >= nums[i + 1]) {
//      i--;
//    }
//    if (i >= 0) {
//      int j = nums.length - 1;
//      while (j >= 0 && nums[j] <= nums[i]) {
//        j--;
//      }
//      swap(nums, j, i);
//    }
//    for (int j = length - 2; j >= 0; j--) {
//      if (prev > nums[j]) {
//        nums[j + 1] = nums[j];
//        nums[j] = prev;
//        break;
//      }
//
//      boolean sorted = true;
//      prev = nums[0];
//      for (int j = 1; j < nums.length; j++) {
//        if (prev > nums[j]) {
//          sorted = false;
//        }
//      }
//      if (sorted) {
//        prev = nums[length - 1];
//        for (int i = length - 2; i >= 0; i--) {
//          if (prev > nums[i]) {
//            nums[i + 1] = nums[i];
//            nums[i] = prev;
//            break;
//          }
//        }
//      } else {
//        Arrays.sort(nums);
//      }
//    }
  }

  private static void swap(int[] nums, int j, int i) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 4};
    nextPermutation(arr);
    System.out.println(Arrays.toString(arr));
  }


}
