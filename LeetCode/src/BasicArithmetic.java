public class BasicArithmetic {
  public static void printFibonacce() {
    int prev = 0;
    int curr = 1;
    int temp;
    for (int i = 0; i < 30; i++) {
      temp = curr;
      curr = curr + prev;
      prev = temp;
      System.out.print(curr + " ");

    }
  }
  public static void armStrongNumber(int x) {
    int remainingSum = x;
    int size;
    while (remainingSum > 0) {
      size = (int) Math.round(Math.pow(remainingSum, 1.0/3));
      System.out.println("size: " + size);
      remainingSum = (int) (remainingSum - Math.pow(size, 3));
      System.out.println(remainingSum);
    }
    System.out.println("Is " + x + " an armstrong number? " + (remainingSum == 0));
  }

  public static int integerPalindrome(int x) {
    int digits = (int) Math.pow(x, 1/10);
    if (digits == 0) return x;
    int val = x;
    int res = 0;
    for (int i = digits; i >= 0; i++) {
      res += (val / Math.pow(10, digits)) * (Math.pow(10, digits - i)) ;
      val = (int) (val - Math.pow(10, digits));

    }
    return res;
  }
  public static void main(String[] args) {
   // printFibonacce();
   // armStrongNumber(129);
    System.out.println(integerPalindrome(123));
  }
}
