package Arrays;

public class FloodFill {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int color = image[sr][sc];
    if (color != newColor) dfs(image, sr, sc, color, newColor);
    return image;
  }
  public void dfs(int[][] image, int r, int c, int color, int newColor) {
    if (image[r][c] == color) {
      image[r][c] = newColor;
      if (r >= 1) dfs(image, r-1, c, color, newColor);
      if (c >= 1) dfs(image, r, c-1, color, newColor);
      if (r+1 < image.length) dfs(image, r+1, c, color, newColor);
      if (c+1 < image[0].length) dfs(image, r, c+1, color, newColor);
    }
  }
//  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//    int initColor = image[sr][sc];
//    image[sr][sc] = newColor;
//    if (image[sr - 1][sc] == initColor) {
//      image[sr - 1][sc] = newColor;
//      floodFill(image, sr - 1, sc, newColor);
//    }
//    if (image[sr][sc - 1] == initColor) {
//      image[sr][sc - 1] = newColor;
//      floodFill(image, sr - 1, sc, newColor);
//
//    }
//    if (image[sr][sc + 1] == initColor) {
//      image[sr][sc + 1] = newColor;
//      floodFill(image, sr - 1, sc, newColor);
//
//    }
//    if (image[sr + 1][sc] == initColor) {
//      image[sr + 1][sc] = newColor;
//      floodFill(image, sr - 1, sc, newColor);
//
//    }
//    return image;
//  }
}
