package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    for(int i = 0; i < nums.length - 2; i++) {
      if(i != 0 && nums[i] == nums[i - 1]) continue; // skip this
      int ptrS = i + 1;
      int ptrL = nums.length - 1;
      while (ptrS < ptrL) {
        if(nums[i] + nums[ptrS] + nums[ptrL] == 0) {
          res.add(Arrays.asList(nums[i], nums[ptrS], nums[ptrL]));
          ptrS++;
          ptrL--;
          // skip same result
          while(ptrS < ptrL && nums[ptrS] == nums[ptrS - 1]) ptrS++;
          while (ptrS < ptrL && nums[ptrL] == nums[ptrL + 1]) ptrL--;
        } else if(nums[i] + nums[ptrS] + nums[ptrL] < 0) {
          ptrS++;
        } else {
          ptrL--;
        }
      }
    }

    return res;
  }

  public List<List<Integer>> threeSumMap(int[] nums) {
    Set<List<Integer>> result = new HashSet<>();
    Map<Integer, Integer> lookup = new HashMap<>(nums.length);
    for (int i = 0; i < nums.length; i++) {
      lookup.put(-nums[i], i); // putting values in map
    }
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int key = nums[i] + nums[j];
        if (lookup.containsKey(key)) {
          int k = lookup.get(key);
          if (k != i && k != j) {
            List<Integer> tuple = Arrays.asList(nums[i], nums[j], nums[k]);
            Collections.sort(tuple);
            result.add(tuple);
          }
        }
      }
    }
    return new ArrayList(result);
  }

}
