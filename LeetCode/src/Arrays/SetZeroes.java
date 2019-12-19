package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SetZeroes {
  public static void setZeroes(int[][] matrix) {
    if (matrix.length == 0) return;
    int row = matrix.length;
    int col = matrix[0].length;
    boolean fstColCheck = false;
    // set first row and col as zeroes
    for (int i = 0; i < row; i++) {
      if (matrix[i][0] == 0) fstColCheck = true;
      for (int j = 1; j < col; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0; // row
          matrix[0][j] = 0; // col
        }
      }
    }

    for (int i = 1; i < row; i++) {
      for (int j = 1; j < col; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    if (matrix[0][0] == 0) {
      for (int j = 0; j < col; j++) {
        matrix[0][j] = 0;
      }
    }

    if (fstColCheck) {
      for (int i = 0; i < row; i++) {
        matrix[i][0] = 0;
      }
    }

  }
  class Solution {
    public void setZeroes(int[][] matrix) {
      Boolean isCol = false;
      int R = matrix.length;
      int C = matrix[0].length;

      for (int i = 0; i < R; i++) {

        // Since first cell for both first row and first column is the same i.e. matrix[0][0]
        // We can use an additional variable for either the first row/column.
        // For this solution we are using an additional variable for the first column
        // and using matrix[0][0] for the first row.
        if (matrix[i][0] == 0) {
          isCol = true;
        }

        for (int j = 1; j < C; j++) {
          // If an element is zero, we set the first element of the corresponding row and column to 0
          if (matrix[i][j] == 0) {
            matrix[0][j] = 0;
            matrix[i][0] = 0;
          }
        }
      }

      // Iterate over the array once again and using the first row and first column, update the elements.
      for (int i = 1; i < R; i++) {
        for (int j = 1; j < C; j++) {
          if (matrix[i][0] == 0 || matrix[0][j] == 0) {
            matrix[i][j] = 0;
          }
        }
      }

      // See if the first row needs to be set to zero as well
      if (matrix[0][0] == 0) {
        for (int j = 0; j < C; j++) {
          matrix[0][j] = 0;
        }
      }

      // See if the first column needs to be set to zero as well
      if (isCol) {
        for (int i = 0; i < R; i++) {
          matrix[i][0] = 0;
        }
      }
    }
  }
  public static void printArray(int[][] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.println(Arrays.toString(array[i]));
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    int[][] array = {{1,2,3}, {0,1,1}};
    setZeroes(array);

  }
}
