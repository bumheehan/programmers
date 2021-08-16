package baekjoon;

import java.io.BufferedReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class DFS와_BFS {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in))) {
      String[] read = br.readLine().split(" ");
      int n = Integer.parseInt(read[0]);
      Node[] arr = new Node[n];
      for (int i = 0; i < n; i++) {
        arr[i] = new Node(i + 1);
      }
      int edge = Integer.parseInt(read[1]);
      int root = Integer.parseInt(read[2]);

      for (int i = 0; i < edge; i++) {
        String[] linkedNode = br.readLine().split(" ");
        arr[Integer.parseInt(linkedNode[0]) - 1].add(arr[Integer.parseInt(linkedNode[1]) - 1]);
      }

      dfsRecur(arr[root - 1]);
      System.out.println();

      for (int i = 0; i < n; i++) {
        arr[i].visit = false;
      }
      bfs(arr[root - 1]);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void bfs(Node root) {
    Queue<Node> qu = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    qu.add(root);
    root.visit = true;
    while (!qu.isEmpty()) {
      Node node = qu.poll();
      System.out.print(node.data);

      node.linked.stream().sorted(new Comparator<Node>() {
        public int compare(Node o1, Node o2) {
          return Integer.compare(o1.data, o2.data);
        };

      }).forEach(s -> {
        if (!s.visit) {
          s.visit = true;
          qu.add(s);
        }
      });
      if (qu.size() > 0) {
        System.out.print(" ");
      }
    }

  }



  public static void bfstodfs(Node root) {

    root.visit = true;
    System.out.print(root.data);

    root.linked.stream().sorted(new Comparator<Node>() {
      public int compare(Node o1, Node o2) {
        return Integer.compare(o2.data, o1.data);
      };
    }).forEach(s -> {
      if (!s.visit) {
        bfstodfs(s);
      }
    });

  }



  public static void dfsRecur(Node root) {

    root.visit = true;
    System.out.print(root.data);
    root.linked.stream().sorted(new Comparator<Node>() {
      public int compare(Node o1, Node o2) {
        return Integer.compare(o1.data, o2.data);
      };

    }).forEach(s -> {
      if (!s.visit) {
        System.out.print(" ");
        dfsRecur(s);
      }
    });
  }

  public static void dfs(Node root) {
    Stack<Node> qu = new Stack<>();

    qu.add(root);
    while (!qu.isEmpty()) {
      Node node = qu.pop();

      if (node.visit) {
        continue;
      }
      System.out.print(node.data);
      node.visit = true;

      node.linked.stream().sorted(new Comparator<Node>() {
        public int compare(Node o1, Node o2) {
          return Integer.compare(o2.data, o1.data);
        };

      }).forEach(s -> {
        qu.add(s);

      });

      if (qu.size() > 0) {
        System.out.print(" ");
      }

    }
  }

  static class Node {
    public Set<Node> linked = new HashSet<>();
    public int data;
    public boolean visit;

    public Node(int i) {
      this.data = i;
    }

    public void add(Node node) {
      if (node != this) {
        this.linked.add(node);
        node.linked.add(this);
      }
    }
  }
}
