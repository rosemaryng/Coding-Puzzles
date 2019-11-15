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
      if (pointer.key == key) {
        return pointer.value;
      }
      pointer = pointer.next;
    }
    return -1;
  }
  public Node getNode(int key) {
    Node pointer = head;
    int i = 0;
    while (i <= size || pointer != null) {
      if (pointer.key == key) {
        return pointer;
      }
      pointer = pointer.next;
    }
    return pointer;
  }

  public void put(int key, int value) {
    if (size == 0) {
      head = new Node(key, value);
      current = head;
      size++;
    } else {
      Node node = getNode(key);
      if (node != null) {
        node.removeNode();
      } else {
        if (size >= capacity) {
          head = head.next;
        } else {
          size++;
        }
      }
      current.next = new Node(key, value, current);
      current = current.next;
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

    public Node(int key, int value, Node prev) {
      this.key = key;
      this.value = value;
      this.prev = prev;
    }

    public void removeNode() {
      prev.next = next;
      next.prev = prev;
    }
  }
}
