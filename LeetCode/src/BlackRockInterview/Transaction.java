//package BlackRockInterview;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
//import java.util.*;
//
//class Main {
//  public static void main(String[] args) throws IOException {
////    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
////    BufferedReader in = new BufferedReader(reader);
////    String line;
////    while ((line = in.readLine()) != null) {
////      Main.matchBenchmark(line);
////    }
////    String[] split =
////            "Vodafone,STOCK,10|Google,STOCK,15|Microsoft,BOND,15:Vodafone,STOCK,15|Google,STOCK,10|Microsoft,BOND,15".split("[,|.:]");
////    System.out.println(Arrays.toString(split));
//
//
//
//    matchBenchmark("Vodafone,STOCK,10|Google,STOCK,15:Vodafone,STOCK,15|Vodafone,BOND,10|Google,STOCK,10");
////    matchBenchmark("Vodafone,STOCK,10|Google,STOCK,15|Microsoft,BOND,15:Vodafone,STOCK,15|Google,STOCK,10|Microsoft,BOND,15");
////
//  }
//
//  public static void matchBenchmark(String input) {
//    List<Character> set = Arrays.asList(':', ',', '|');
//    String[] inputs = input.split(":");
//
//    PriorityQueue<Asset> portfolio = addProfile(inputs[0].split("[,|.:]"));
//    PriorityQueue<Asset> benchmark = addProfile(inputs[1].split("[,|.:]"));
//    System.out.println("portfolio:" + portfolio);
//    System.out.println("benchmark: " + benchmark);
//    PriorityQueue<Asset> buy = new PriorityQueue<>();
//    PriorityQueue<Asset> sell = new PriorityQueue<>();
//    int i = 0;
//    // Priority queue is only sorted when poll/peek
//
//    while (!portfolio.isEmpty()){
//      Asset a = portfolio.peek();
//      Asset b = benchmark.peek();
//      System.out.println("a: " + a + " b: " + b + "compare: " + a.compareTo(b));
//      if (a.compareTo(b) == 0) {
//        if (a.share > b.share) {
//          sell.add(new Asset(a.company, a.assetType, a.share - b.share));
//        } else if (a.share < b.share) {
//          buy.add(new Asset(a.company, a.assetType, b.share - a.share));
//        }
//        portfolio.poll();
//        benchmark.poll();
//      } else if (a.compareTo(b) > 0) {
//        buy.add(benchmark.poll());
//      } else {
//        sell.add(portfolio.poll());
//      }
//      System.out.println("buy " + buy);
//      System.out.println("Sell" + sell);
//
//
//    }
//    System.out.println(benchmark);
//    System.out.println("buy " + buy);
//    System.out.println("Sell" + sell);
//    while (!sell.isEmpty()) {
//      System.out.print("SELL," + sell.poll() + " ");
//    }
//    while (!buy.isEmpty()) {
//      System.out.print("BUY," + buy.poll()+ " ");
//    }
//  }
//
//  private static PriorityQueue<Asset> addProfile(String[] string) {
//    PriorityQueue<Asset> profile = new PriorityQueue<>();
//    assert (string.length % 3 == 0);
//    for (int i = 0; i < string.length; i = i + 3) {
//      Asset asset = new Asset(string[i], string[i + 1], string[i + 2]);
//      profile.add(asset);
//    }
//    return profile;
//  }
//
//
//  private static class Asset implements Comparable<Asset> {
//    String company;
//    AssetType assetType;
//    int share; // assume it will be int instead of doubles
//
//    public Asset() {
//    }
//
//    public Asset(String company, String assetType, String share) {
//      assert (Integer.parseInt(share) >= 0);
//      this.company = company;
//      this.assetType = (assetType.equals("STOCK")) ? AssetType.STOCK : AssetType.BOND;
//      this.share = Integer.parseInt(share);
//    }
//
//    public Asset(String company, AssetType assetType, int share) {
//      this.company = company;
//      this.assetType = assetType;
//      this.share = share;
//    }
//
//    @Override
//    public int compareTo(Asset a2) {
//      if (this.company.compareTo(a2.company) == 0) {
//        if (this.assetType.equals(a2.assetType)) {
//          return 0; // if the same company and same asset type
//        } else if (this.assetType.equals(AssetType.BOND)){
//          return -1;
//        } else {
//          return 1;
//        }
//      } else {
//        return this.company.compareTo(a2.company);
//      }
//    }
//
//    @Override
//    public boolean equals(Object o) {
//      if (! (o instanceof Asset)) return false;
//      Asset asset = (Asset) o;
//      return share == asset.share &&
//              Objects.equals(company, asset.company) &&
//              assetType == asset.assetType;
//    }
//
//    @Override
//    public int hashCode() {
//      return Objects.hash(company, assetType, share);
//    }
//
//    @Override
//    public String toString() {
//      return company + "," + assetType + "," + share;
//    }
//
//  }
//
//  private enum AssetType {
//    STOCK,
//    BOND
//  }
//
//}