package DataStructureDesign;

import java.util.List;

class LRUCache {

  private int[] keys;
  private int[] values;
  int current = 0;

  public LRUCache(int capacity) {
    this.keys = new int[capacity];
    this.values = new int[capacity];
  }

  public int get(int key) {
    for (int i = 0; i < current; i++) {
      if (key == keys[i]) {
        return values[i];
      }
    }
    return -1;
  }

  public void put(int key, int value) {
    int getkey = get(key);
    if (getkey != -1) {
      keys[current] = key;
      values[current] = value;
      current++;
    } else {
      values[getkey] = value;
    }

  }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */