package datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class DfsAndBfs {

  static class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    boolean mark;
    Set<Node<T>> linkedNode;
    T data;

    public Node(T data) {
      this.data = data;
      this.linkedNode = new TreeSet<>();
    }

    @Override
    public int compareTo(Node<T> o) {
      return data.compareTo(o.data) * -1;
    }

    public void addNode(Node<T> node) {
      if (this.equals(node))
        return;
      this.linkedNode.add(node);
      node.linkedNode.add(this);
    }
  }

  public static <T extends Comparable<T>> void dfs(Node<T> root) {
    Stack<Node<T>> stack = new Stack<Node<T>>();
    stack.add(root);
    while (!stack.isEmpty()) {
      Node<T> bNode = stack.pop();
      if (bNode.mark) {
        continue;
      }
      bNode.mark = true;
      //logic
      System.out.println(bNode.data);

      for (Node<T> bLinkedNode : bNode.linkedNode) {
        stack.push(bLinkedNode);
      }
    }
  }

  public static <T extends Comparable<T>> void bfs(Node<T> root) {
    Queue<Node<T>> queue = new LinkedList<Node<T>>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node<T> bNode = queue.poll();
      if (bNode.mark) {
        continue;
      }
      bNode.mark = true;
      //logic
      System.out.println(bNode.data);

      for (Node<T> bLinkedNode : bNode.linkedNode) {
        queue.add(bLinkedNode);
      }
    }
  }

  public static void main(String[] args) {
    Node<Integer> a = new Node<Integer>(0);
    Node<Integer> b = new Node<Integer>(1);
    Node<Integer> c = new Node<Integer>(2);
    Node<Integer> d = new Node<Integer>(3);
    Node<Integer> e = new Node<Integer>(4);

    a.addNode(b);
    a.addNode(c);
    a.addNode(e);
    b.addNode(c);
    c.addNode(e);
    d.addNode(c);
    d.addNode(e);
    System.out.println("dfs");
    dfs(a);

    a.mark = false;
    b.mark = false;
    c.mark = false;
    d.mark = false;
    e.mark = false;

    System.out.println("bfs");
    bfs(a);
  }


}
