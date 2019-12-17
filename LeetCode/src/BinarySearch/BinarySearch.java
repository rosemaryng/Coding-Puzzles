package BinarySearch;

public class BinarySearch {
  public int search(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) return i;
    }
    return -1;
  }

  public int binarySearch(int[] nums, int target) {
    int pivot, left = 0, right = nums.length - 1;
    while (left <= right) {
      pivot = left + (right - left) / 2;
      if (nums[pivot] == target) return pivot;
      if (target < nums[pivot]) right = pivot - 1;
      else left = pivot + 1;
    }
    return -1;
  }

  public int firstBadVersion(int n) {
//    int head = 0, end = n;
//    while (head < end) {
//      int mid = head + (end - head) / 2;;
//      if (isBadVersion(mid)) {
//        if (!isBadVersion(mid - 1)) {
//          return mid;
//        } else {
//          end = mid - 1;
//        }
//      } else {
//        if (isBadVersion(mid + 1)) {
//          return mid + 1;
//        } else {
//          head = mid + 1;
//        }
//      }
//    }
    return -1;
}
  public int findPeakElement(int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
      int mid = (l + r) / 2;
      if (nums[mid] > nums[mid + 1])
        r = mid;
      else
        l = mid + 1;
    }
    return l;
  }}
