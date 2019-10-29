package BlackRockInterview;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;

public class CashRegister {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader in = new BufferedReader(reader);

    try {
      double purchasePrice = Double.parseDouble(in.readLine());
      double cash = Double.parseDouble(in.readLine());
      CashRegister.calculateChange(purchasePrice, cash);
    } catch (Exception e) {
      System.out.println(e);
    }

//    BigDecimal a = new BigDecimal("0.05");
//    BigDecimal b = a.subtract(new BigDecimal("0.045"));
//    System.out.println(b);
  }

  public static void calculateChange(double purchasePrice, double cash) {
    if (purchasePrice > cash) {
      throw new IllegalArgumentException("ERROR");
    }
    if (purchasePrice == cash) {
      System.out.println("Zero");
    }
    BigDecimal remainingChange = new BigDecimal(Double.toString(cash - purchasePrice));
    Change change = new Change();
    for (int i = 0; i < change.coins.length && remainingChange.compareTo(new BigDecimal("0")) > 0; i++) {
      BigDecimal currentCoin = new BigDecimal(Double.toString(change.coins[i]));
      System.out.println("currentCoin: " + currentCoin + " remainingChange: " + remainingChange);
      if (remainingChange.compareTo(currentCoin) >= 0 ) {
        System.out.println("if entered");
        BigDecimal amount = remainingChange.divide(currentCoin);
        for (int j = 0; j < amount.intValue(); j++) {
          change.add(currentCoin.toString());
          System.out.println("Adding " + currentCoin);
          remainingChange = remainingChange.subtract(currentCoin);
        }
        System.out.println("remainingChange after deduction:" + remainingChange);
      }
    }
    System.out.println("price: " + purchasePrice + "Cash: " + cash);
    System.out.println(change.changes);
    System.out.println("changes: " + change);
  }

  private static class Change {
    private final double[] coins = {50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};
    private List<String> changes;
    private Map<String, String> map = new HashMap<>();

    public Change() {
      this(new ArrayList<>());
    }

    public Change(List<String> changes) {
      this.changes = changes;
    }

    public void add(String amount) {
      changes.add(amount);
      map.put("50.0", "Fifty Pounds");
      map.put("20.0", "Twenty Pounds");
      map.put("10.0", "Ten Pounds");
      map.put("5.0", "Five Pounds");
      map.put("2.0", "Two Pounds");
      map.put("1.0", "One Pounds");
      map.put("0.5", "Fifty Pence");
      map.put("0.2", "Twenty Pence");
      map.put("0.1", "Ten Pence");
      map.put("0.05", "Five Pence");
      map.put("0.02", "Two Pence");
      map.put("0.01", "One Pence");
    }

    //int position;
//    Map<Double, String> map = new HashMap<>();
    String[] valueStrings = {"Fifty Pounds", "Twenty Pounds", "Ten Pounds", "Five Pounds", "Two Pounds", "One Pounds",
            "Fifty Pence", "Twenty Pence", "Ten Pence", "Five Pence", "Two Pence", "One Pence" };

    @Override
    public String toString() {
      String res = "";
      for (int i = 0; i < changes.size(); i++) {
        res += map.get(changes.get(i));
        if (i != changes.size() - 1 ) {
          res += ", ";
        }
      }
      return res;
    }
  }
}