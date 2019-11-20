package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    for (int n : nums) list.add(n); //This step is turning array to a list only
    int length = nums.length;
    permute(list, res, length, 0);
    return res;
  }

  private void permute(List<Integer> list, List<List<Integer>> res, int length, int index) {
    if (index == length) res.add(new ArrayList<Integer>(list));
    for (int i = index; i < length ; i++) {
      Collections.swap(list, index, i);
      permute(list, res, length, index + 1);
      Collections.swap(list, index, i);
    }
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    if (nums == null || nums.length == 0) return new ArrayList<>();
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    permuteUniqueRecur(nums, res, new ArrayList<>(), new boolean[nums.length]);
    return res;
  }

  private void permuteUniqueRecur(int[] nums, List<List<Integer>> finalResult, List<Integer> currResult, boolean[] used) {
    if (currResult.size() == nums.length) {
      finalResult.add(new ArrayList<>(currResult));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i] || (i > 0 && !used[i - 1] && nums[i] == nums[i - 1])) {
        continue;
      }
      currResult.add(nums[i]);
      used[i] = true;
      permuteUniqueRecur(nums, finalResult, currResult, used);
      used[i] = false;
      currResult.remove(currResult.size() - 1);
    }
  }

  public boolean permutationInString(String s1, String s2) {
    if (s1.length() > s2.length()) return false;

    return false;
  }

  public static void main(String[] args) {
    Permutations permClass = new Permutations();
    int[] array = {1,2,3};
    permClass.permute(array);
  }

}
