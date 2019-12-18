package Graphs;

public class NumberOfIslands {

  char[][] grid;

  public int numIslands(char[][] grid) {
    int islands = 0;
    this.grid = grid;
    for (int i = 0; i < this.grid.length; i++) {
      for (int j = 0; j < this.grid[i].length; j++) {
        islands += sink(i, j);
      }
    }
    return islands;
  }

  int sink(int i, int j) {
    if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == '0') {
      return 0;
    }
    grid[i][j] = '0';
    sink(i + 1, j);
    sink(i - 1, j);
    sink(i, j + 1);
    sink(i, j - 1);
    return 1;
  }

  int[] d = {0, 1, 0, -1, 0};

  int sink2(int i, int j) {
    if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == '0') {
      return 0;
    }
    grid[i][j] = '0';
    for (int k = 0; k < 4; k++) {
      sink2(i + d[k], j + d[k + 1]);
    }
    return 1;
  }


  public int numIslandsMINE(char[][] grid) {
    int count = 0;
    int row = grid.length;
    if (row == 0) {
      return 0;
    }
    int col = grid[0].length;

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == '1') { // 2 is visited + part of island
          System.out.println("entered?");
          grid[i][j] = '2';
          count += checkNeigbours(grid, i, j, row, col) ? 1 : 0;
        } else if (grid[i][j] == '2') {
          checkNeigbours(grid, i, j, row, col);
        }
      }
    }
    return count;
  }

  private boolean checkNeigbours(char[][] grid, int i, int j, int row, int col) {
    boolean hasNeighbours = false;
    if (i < row - 1 && grid[i + 1][j] == '1') {
      grid[i + 1][j] = '2'; // check bottom
    } else if (i < row - 1 && grid[i + 1][j] == '2') {
      hasNeighbours = true;
    }
    if (j < col - 1 && grid[i][j + 1] == '1') {
      grid[i][j + 1] = '2'; // check right
    } else if (j < col - 1 && grid[i][j + 1] == '2') {
      hasNeighbours = true;
    }
    if (i > 0 && grid[i - 1][j] != '0' || j > 0 && grid[i][j - 1] != '0'
        || hasNeighbours) { // Up and left has been visited
      return false;
    }
    return true;
  }
}