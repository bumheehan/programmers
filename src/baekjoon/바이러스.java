package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 바이러스 {

  public static void main(String[] args) throws IOException {

    try (BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      Node[] nodes = new Node[n];
      for (int i = 0; i < n; i++) {
        nodes[i] = new Node(i + 1);
      }

      int edgeCount = Integer.parseInt(br.readLine());
      for (int i = 0; i < edgeCount; i++) {
        String[] lines = br.readLine().split(" ");
        int node1 = Integer.parseInt(lines[0]);
        int node2 = Integer.parseInt(lines[1]);
        nodes[node1 - 1].add(nodes[node2 - 1]);
      }
      System.out.println(bfs(nodes, 0));
    }


  }

  public static int bfs(Node[] nodes, int idx) {

    Node root = nodes[idx];
    root.visited = true;
    Queue<Node> qu = new LinkedList<>();
    qu.add(root);
    int count = 0;
    while (!qu.isEmpty()) {
      Node node = qu.poll();
      for (Node lNode : node.linkedNode) {

        if (!lNode.visited) {
          lNode.visited = true;
          qu.add(lNode);
          count++;
        }
      }
    }
    return count;
  }



  static class Node {
    Set<Node> linkedNode;
    int data;
    boolean visited;

    Node(int data) {
      this.data = data;
      this.linkedNode = new HashSet<>();
    }

    public void add(Node node) {
      this.linkedNode.add(node);
      node.linkedNode.add(this);
    }

    @Override
    public String toString() {
      return "Node [linkedNode=" + linkedNode + ", data=" + data + ", visited=" + visited + "]";
    }


  }

}
