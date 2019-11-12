package DataStructureDesign;

public class LRUCacheLinkedList {
  Node head;
  Node current;
  int size = 0;
  int capacity;


  public LRUCacheLinkedList(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    Node pointer = head;
    int i = 0;
    while (i <= size || pointer != null) {

    }

  }

  public void put(int key, int value) {
    if (size == 0) {
      head = new Node(key, value);
      current = head;
    } else if (size < capacity) {

    }

  }
  class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
      this.prev = null;
      this.next = null;
    }
  }
}
