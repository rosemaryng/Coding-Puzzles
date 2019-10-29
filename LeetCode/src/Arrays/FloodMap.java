package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FloodMap {
  static int[][] map;

  public FloodMap() {
    map = new int[5][5];
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        map[i][j] = 0;

      }

    }
  }

  public static List<Integer> validNeighbours(int x, int y, int[][] map, int n) {
    List<Integer> list = new ArrayList<>();
    if (x > 0) {
      list.add(map[x - 1][y]); // top M
      if (y > 0) {
        list.add(map[x - 1][y - 1]); //top L
      }
    }
    if (y > 0) {
      list.add(map[x][y - 1]); // Mid L
      if (x < n) {
        list.add(map[x + 1][y - 1]); //Bottom L
      }
    }
    if (x < n) {
      list.add(map[x + 1][y]); // Bottom M
      if (y < n) {
        list.add(map[x + 1][y + 1]); //bottom R
      }
    }
    if (y < n) {
      list.add(map[x][y + 1]); //Mid R
      if (x > 0) {
        list.add(map[x - 1][y + 1]); //top R
      }
    }
    return list;
  }

  public static void checkHighestHelper(int x, int y, int[][] givenmap, int n) {
    int largest = givenmap[x][y];
    if (x > 0) {
      largest = Math.max(largest, givenmap[x - 1][y]);// top M
      if (y > 0) {
        largest = Math.max(largest, givenmap[x - 1][y - 1]); //top L
      }
    }
    if (y > 0) {
      largest = Math.max(largest, givenmap[x][y - 1]); // Mid L
      if (x < n) {
        largest = Math.max(largest, givenmap[x + 1][y - 1]); //Bottom L
      }
    }
    if (x < n) {
      largest = Math.max(largest, givenmap[x + 1][y]); // Bottom M
      if (y < n) {
        largest = Math.max(largest, givenmap[x + 1][y + 1]); //bottom R
      }
    }
    if (y < n) {
      largest = Math.max(largest, givenmap[x][y + 1]); //Mid R
      if (x > 0) {
        largest = Math.max(largest, givenmap[x - 1][y + 1]); //top R
      }
    }
    map[x][y] = (givenmap[x][y] == largest) ? 1 : 0;
  }

  public static int[][] checkHighest(int[][] givenMap, int n) {
    for (int i = 0; i < n ; i++) {
      for (int j = 0; j < n ; j++) {
        checkHighestHelper(i, j, givenMap, n);
      }
    }
    return map;
  }

  public static String print(int[][] map, int n) {
    String res = "";
    for (int i = 0; i < n ; i++) {
      for (int j = 0; j < n ; j++) {
        res += map[i][j] +  " ";
      }
      res += "\r\n";

    }
    return res;
  }

  public static void main(String[] args) {

    int arr[][] = { { 0, 0, 0, 7, 0 },
            { 7, 0, 0, 6, 1 },
            { 0, 0, 0, 4, 0 },
            { 6, 0, 5, 0, 9 },
            { 0, 0, 4, 0, 0 } };

    System.out.println(validNeighbours(0,0,arr,5));
    FloodMap floodMap = new FloodMap();
    System.out.println(floodMap.print(arr, 5));
    floodMap.checkHighest(arr, 4);
    System.out.printf(floodMap.print(map,5));
  }

//  public static int[][] findRiskScores(int[][] elevations) {
//    // Write your code here
//    int n = elevations.length;
//    int m = elevations[0].length;
//    int[][] score = new int[n][m];
//    for(int i = 0; i < n; i ++) {
//      for (int j = 0; j < m; j++) {
//
//      }
//    }
//
//  }

  private void checkScore(int x, int y, int n, int m, int[][] elevations, int[][] score) {

  }
}
