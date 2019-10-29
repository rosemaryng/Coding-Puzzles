package Arrays;

public class Easy {
  /*
  Question 1: Rotate
   */
  public void rotate(int[] nums, int k) {
    int length = nums.length;
    if ((k % length) == 0 || length == 1)  {return;}
    int count = 0;
    for(int i = 0; i < length; i++) {
      int current = i;
      int prev = nums[i];
      do {
        int next = (current + k) % length;
        int temp = nums[next];
        nums[next] = prev;
        prev = temp;
        current = next;
        count++;
      } while (i != current);
    }
  }

  public void rotateExtraArray(int[] nums, int k) {
    int length = nums.length;
    if ((k % length) == 0 || length == 1)  {return;}
    int[] temp = new int[length];
    for(int i = 0; i < length; i++) {
      int loc = (i + k) % length;
      temp[loc] = nums[i];
    }
    for(int i = 0;i < length; i++) {
      nums[i] = temp[i];
    }
  }
}
