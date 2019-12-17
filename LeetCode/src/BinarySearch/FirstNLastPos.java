package BinarySearch;

public class FirstNLastPos {

    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
      int lo = 0;
      int hi = nums.length;

      while (lo < hi) {
        int mid = (lo + hi) / 2;
        if (nums[mid] > target || (left && target == nums[mid])) {
          hi = mid;
        }
        else {
          lo = mid+1;
        }
      }

      return lo;
    }

    public int[] searchRange(int[] nums, int target) {
      int[] targetRange = {-1, -1};

      int leftIdx = extremeInsertionIndex(nums, target, true);

      // assert that `leftIdx` is within the array bounds and that `target`
      // is actually in `nums`.
      if (leftIdx == nums.length || nums[leftIdx] != target) {
        return targetRange;
      }

      targetRange[0] = leftIdx;
      targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

      return targetRange;
    }
  }

