import BlackRockInterview.CashRegister;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CashRegisterNice {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader in = new BufferedReader(reader);

    try {
      double purchasePrice = Double.parseDouble(in.readLine());
      double cash = Double.parseDouble(in.readLine());
      CashRegisterNice.calculateChange(purchasePrice, cash);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void calculateChange(double purchasePrice, double cash) {
    if (purchasePrice > cash) {
      System.out.println("ERROR");
      return;
      //throw new IllegalArgumentException("ERROR");
    }

    if (purchasePrice == cash) {
      System.out.println("Zero");
      return;
    }
  /* BigDecimal is utilised for handling currencies accurately -- storing as Double is sometimes not accurate, e.g. 0.05 would be stored
       as 0.0499999999999 because of binary number conversions */

    BigDecimal remainingChange = new BigDecimal(Double.toString(cash - purchasePrice));
    Change change = new Change();
    for (int i = 0; i < change.coins.length && remainingChange.compareTo(new BigDecimal("0")) > 0; i++) {
      BigDecimal currentCoin = new BigDecimal(Double.toString(change.coins[i]));
      if (remainingChange.compareTo(currentCoin) >= 0 ) {
        BigDecimal amount = remainingChange.divide(currentCoin);    // the amount of the same note/coin
        for (int j = 0; j < amount.intValue(); j++) {
          change.add(currentCoin.toString());
          remainingChange = remainingChange.subtract(currentCoin);
        }
      }
    }
    System.out.println(change);
  }

  private static class Change {
    private final double[] coins = {50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01}; // the list of all available notes/coins
    private List<String> changes; // the list of changes that are going to return
    private Map<String, String> map = new HashMap<>(); // the map storing the key value pair of changes and the print value

    public Change() {
      this(new ArrayList<>());
    }

    public Change(List<String> changes) {
      this.changes = changes;
      map.put("50.0", "Fifty Pounds");
      map.put("20.0", "Twenty Pounds");
      map.put("10.0", "Ten Pounds");
      map.put("5.0", "Five Pounds");
      map.put("2.0", "Two Pounds");
      map.put("1.0", "One Pound");
      map.put("0.5", "Fifty Pence");
      map.put("0.2", "Twenty Pence");
      map.put("0.1", "Ten Pence");
      map.put("0.05", "Five Pence");
      map.put("0.02", "Two Pence");
      map.put("0.01", "One Pence");
    }

    public void add(String amount) {
      changes.add(amount);
    }

    @Override
    public String toString() { // returning the print message
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