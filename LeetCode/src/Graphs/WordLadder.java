//package Graphs;
//
//
//import javafx.util.Pair;
//
//import java.util.*;
//
//public class WordLadder {
//
//  public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
//
//    // Since all words are of same length.
//    int L = beginWord.length();
//
//    // Dictionary to hold combination of words that can be formed,
//    // from any given word. By changing one letter at a time.
//    HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();
//
//    wordList.forEach(
//            word -> {
//              for (int i = 0; i < L; i++) {
//                // Key is the generic word
//                // Value is a list of words which have the same intermediate generic word.
//                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
//                ArrayList<String> transformations =
//                        allComboDict.getOrDefault(newWord, new ArrayList<String>());
//                transformations.add(word);
//                allComboDict.put(newWord, transformations);
//              }
//            });
//
//    // Queue for BFS
//
//    Queue<Pair<String, Integer>> Q = new LinkedList<Pair<String, Integer>>();
//    Q.add(new Pair(beginWord, 1));
//
//    // Visited to make sure we don't repeat processing same word.
//    HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
//    visited.put(beginWord, true);
//
//    while (!Q.isEmpty()) {
//      Pair<String, Integer> pair = Q.remove();
//      String word = pair.getKey();
//      int level = pair.getValue();
//      for (int i = 0; i < L; i++) {
//
//        // Intermediate words for current word
//        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
//
//        // Next states are all the words which share the same intermediate state.
//        for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
//          // If at any point if we find what we are looking for
//          // i.e. the end word - we can return with the answer.
//          if (adjacentWord.equals(endWord)) {
//            return level + 1;
//          }
//          // Otherwise, add it to the BFS Queue. Also mark it visited
//          if (!visited.containsKey(adjacentWord)) {
//            visited.put(adjacentWord, true);
//            Q.add(new Pair(adjacentWord, level + 1));
//          }
//        }
//      }
//    }
//    return 0;
//  }
//
//  public static void main(String[] args) {
//    List<String> list = Arrays.asList("ynd", "yad", "end", "eys", "ens", "yns" );
//    System.out.println( ladderLength("yes", "end", list));
//
//  }
//
//}
