package Arrays;

public class MultiplyString {

  public static String multiply(String num1, String num2) {
    int p1 = num1.length(), p2 = num2.length();
    int res[] = new int[p1 + p2]; // store as int array
    for (int i = p1 - 1; i >= 0; i--) {
      int carry = 0; // carry is reset
      for (int j = p2 - 1; j >= 0 ; j--) {
        int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry + res[i+j+1]; // multiply + carry + decimal added
        carry = mul / 10;
        res[i+j+1] = mul % 10;
      }
      res[i] = carry; // put the carry in front
    }
    StringBuilder sb = new StringBuilder();
    for(int p : res) if(!(sb.length() == 0 && p == 0)) sb.append(p);
    return sb.length() == 0 ? "0" : sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(multiply("123", "456"));

  }
}
