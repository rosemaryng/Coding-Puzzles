package Arrays;

public class BackSpaceStringCompare {
  public boolean backspaceCompare(String S, String T) {
    int s = S.length() - 1;
    int t = T.length() - 1;
    while (s >= 0 && t >= 0) {
      if (S.charAt(s) != T.charAt(t)) return false;
      s -=  S.charAt(s) == '#' ? 2 : 1;
      t -= T.charAt(t) == '#' ? 2 : 1;
    }
  return s == -1 && t == -1;
  }

  public boolean backspaceCompareSol(String S, String T) {

    int i = S.length() - 1, j = T.length() - 1;
    int skipS = 0, skipT = 0;

    while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
      while (i >= 0) { // Find position of next possible char in build(S)
        if (S.charAt(i) == '#') {
          skipS++;
          i--;
        } else if (skipS > 0) {
          skipS--;
          i--;
        } else break;
      }
      while (j >= 0) { // Find position of next possible char in build(T)
        if (T.charAt(j) == '#') {
          skipT++;
          j--;
        } else if (skipT > 0) {
          skipT--;
          j--;
        } else break;
      }
      // If two actual characters are different
      if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
        return false;
      // If expecting to compare char vs nothing
      if ((i >= 0) != (j >= 0))
        return false;
      i--;
      j--;
    }
    return true;
  }
}
