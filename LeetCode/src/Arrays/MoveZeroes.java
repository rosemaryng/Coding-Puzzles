package Arrays;


import java.util.Arrays;

public class MoveZeroes {
  // my method is swapping
  public static void moveZeroes(int[] nums) {
    int i = 0, j = nums.length - 1;
    boolean swapped = false;
    while (i < j) {
      if (nums[j] == 0) {
        j--;
      }
      if (nums[i] == 0) {
        swap(i, j, nums);
        swapped = true;
        j--;
      } else if (swapped) {
        swap(i, j, nums);
        swapped = false;
      } else {
        i++;
      }
      System.out.println(Arrays.toString(nums));
    }
  }

  public static void moveZeroesSolAppend0s(int[] nums) {
    int index = 0; // index of last non-Zero found
    int length = nums.length;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) nums[index++] = nums[i]; //covering all Zeroes
    }
    // All non-zeroes are in beginning of array
    for (int i = index; i < length; i++) {
      nums[i] = 0;
    }
  }
  public static void moveZeroesSolSwap(int[] nums) {
    for (int lastNonZeroFoundAt = 0, i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        swap(lastNonZeroFoundAt++, i, nums);
      }
    }
  }

  private static void swap(int i, int j, int[] nums) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }


  public static void main(String[] args) {
    int[] nums = {0,1,0,2};
    System.out.println(Arrays.toString(nums));
    moveZeroes(nums);
    System.out.println(Arrays.toString(nums));
  }
}
