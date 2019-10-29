package ListAndNumbers;

public class MedianOfTwoSortedArray {

  public static double median(int[] array1, int[] array2) {
    int totalLength = array1.length + array2.length;
    int median = totalLength / 2;
    int j = 0, counter = 0;
    int i;
    for (i = 0; i < array1.length - (median % 2) & counter < median; i++) {
      if (array2[j] >= array1[i] || j >= array2.length) {
        counter++;
      } else {
        while (array2[j] < array1[i] && j < array2.length) {
          j++;
        }
      }
    }
    if (totalLength % 2 != 0) {
      if (array1[i] > array2[j] || i >= array1.length) {
        return array2[j];
      } else {
        return array1[i];
      }
    } else {
      int sum = 0;
      for (int k = 0; k < 2 ; k++) {
        if (i >= array1.length || array1[i] > array2[j]) {
          sum += array2[j];
          j++;
        } else {
          sum += array1[i];
          i++;
        }

      }
      return sum / 2.0;
    }
//    for (int i = 0; i < ; i++) {

  }

  public static void main(String[] args) {
    int ar1[] = {1, 2, 4};
    int ar2[] = {7, 8};
    System.out.println(median(ar1, ar2));
  }
}
