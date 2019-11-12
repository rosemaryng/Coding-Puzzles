package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    int length = matrix.length;
    if (length == 0) return res;
    int width = matrix[0].length;
    int min = Math.min(length, width);
    int iterations = min / 2 + min % 2;
    int size = length * width;
    int currAdded = 0;
    for (int i = 0; i < iterations && currAdded < size; i++) {
      for (int j = i; j < width - i; j++) {
        res.add(matrix[i][j]);
      }
      if (res.size() == width * length) return res;
      for (int j = i + 1; j < length - i - 1; j++) {
        res.add(matrix[j][width - 1 - i]);
      }
      if (res.size() == width * length) return res;

      for (int j = width - 1 - i; j >= i; j--) {
        res.add(matrix[length - 1 - i][j]);
      }
      if (res.size() == width * length) return res;

      for (int j = length - i - 2; j > i; j--) {
        res.add(matrix[j][i]);
      }
      if (res.size() == width * length) return res;

    }
    return res;
  }

  public static List<Integer> spiralOrderSolUsingDirection(int[][] matrix) {
    List ans = new ArrayList();
    if (matrix.length == 0) return ans;
    int R = matrix.length, C = matrix[0].length;
    boolean[][] seen = new boolean[R][C];
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};
    int r = 0, c = 0, di = 0;
    //Keeping track of the total number to be counted
    for (int i = 0; i < R * C; i++) {
      ans.add(matrix[r][c]);
      seen[r][c] = true;
      int cr = r + dr[di];
      int cc = c + dc[di];
      //Out of bounds/visited -- change direction
      if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]) {
        r = cr;
        c = cc;
      } else {
        di = (di + 1) % 4;
        r += dr[di];
        c += dc[di];
      }
    }
    return ans;
  }

  public List < Integer > spiralOrderSolLayer(int[][] matrix) {
    List ans = new ArrayList();
    if (matrix.length == 0)
      return ans;
    int row = 0, length = matrix.length - 1;
    int col = 0, width = matrix[0].length - 1;
    while (row <= length && col <= width) {
      for (int c = col; c <= width; c++) ans.add(matrix[row][c]);
      for (int r = row + 1; r <= length; r++) ans.add(matrix[r][width]);
      if (row < length && col < width) {
        for (int c = width - 1; c > col; c--) ans.add(matrix[length][c]);
        for (int r = length; r > row; r--) ans.add(matrix[r][col]);
      }
      row++;
      length--;
      col++;
      width--;
    }
    return ans;
  }

  public static void main(String[] args) {
    int matrix[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//    {1,2,3,4},{5,6, 7,8},{9,10,11,12}
    System.out.println(spiralOrder(matrix));
    System.out.println(spiralOrderSolUsingDirection(matrix));
  }


}
