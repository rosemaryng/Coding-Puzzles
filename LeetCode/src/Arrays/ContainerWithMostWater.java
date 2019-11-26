package Arrays;

public class ContainerWithMostWater {

  public int maxArea(int[] height) {
    int ptrL = 0, ptrR = height.length - 1;
    int max = 0;
    while (ptrR > ptrL) {
      System.out.println("ptrL: " + height[ptrL] + " ptrR: " + height[ptrR]);
      int area = Math.min(height[ptrL], height[ptrR]) * (ptrR - ptrL);
      max = Math.max(area, max);
      if (height[ptrR] > height[ptrL]) {
        ptrL++;
      } else {
        ptrR--;
      }
    }
    return max;

  }

  public static void main(String[] args) {
    int[] array = {2,3,4,5,18,17,6};
    ContainerWithMostWater container = new ContainerWithMostWater();
    System.out.println(container.maxArea(array));
  }

}
